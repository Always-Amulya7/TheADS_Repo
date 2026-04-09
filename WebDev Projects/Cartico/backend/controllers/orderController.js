/**
 * Order Controller
 * Handles order creation and management
 */

const Order = require('../models/Order');
const Cart = require('../models/Cart');
const Product = require('../models/Product');
const Coupon = require('../models/Coupon');
const { sendOrderConfirmation, sendOrderShipped, sendOrderDelivered } = require('../services/emailService');
const stripeService = require('../services/stripeService');
const razorpayService = require('../services/razorpayService');
const { AppError } = require('../middleware/errorHandler');

/**
 * Create new order
 */
const createOrder = async (req, res, next) => {
  try {
    const { shippingAddress, paymentMethod, paymentIntentId } = req.body;

    // Get user's cart
    const cart = await Cart.findOne({ user: req.user._id })
      .populate({
        path: 'items.product',
        populate: { path: 'seller', select: 'name' }
      });

    if (!cart || cart.items.length === 0) {
      return next(new AppError('Cart is empty', 400));
    }

    // Verify stock availability
    for (const item of cart.items) {
      const product = item.product;
      if (!product || !product.isActive) {
        return next(new AppError(`Product ${item.name} is no longer available`, 400));
      }
      if (product.stock < item.quantity) {
        return next(new AppError(`Insufficient stock for ${item.name}. Available: ${product.stock}`, 400));
      }
    }

    // Calculate totals
    cart.calculateTotals();

    // Check for coupon
    let discountPrice = 0;
    let couponUsed = null;
    if (cart.appliedCoupon) {
      const coupon = await Coupon.findById(cart.appliedCoupon);
      if (coupon && coupon.isValid()) {
        discountPrice = cart.discountPrice;
        couponUsed = coupon._id;
        coupon.usageCount += 1;
        await coupon.save();
      }
    }

    // Create order
    const order = new Order({
      user: req.user._id,
      orderItems: cart.items.map(item => ({
        product: item.product._id,
        name: item.product.name,
        price: item.price,
        quantity: item.quantity,
        image: item.image,
        color: item.color,
        size: item.size,
        seller: item.product.seller._id
      })),
      shippingAddress,
      paymentMethod,
      paymentGateway: ['stripe', 'razorpay'].includes(paymentMethod) ? paymentMethod : 'none',
      itemsPrice: cart.itemsPrice,
      shippingPrice: cart.shippingPrice,
      taxPrice: cart.taxPrice,
      discountPrice,
      totalPrice: cart.totalPrice,
      couponUsed,
      couponDiscount: discountPrice
    });

    const createdOrder = await order.save();

    // Update product stock
    for (const item of cart.items) {
      await Product.findByIdAndUpdate(item.product._id, {
        $inc: { stock: -item.quantity }
      });
    }

    // Clear the cart
    cart.items = [];
    cart.appliedCoupon = null;
    cart.discountPrice = 0;
    cart.calculateTotals();
    await cart.save();

    // Send order confirmation email
    sendOrderConfirmation(createdOrder, req.user).catch(console.error);

    res.status(201).json({
      success: true,
      data: createdOrder
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get user's orders
 */
const getMyOrders = async (req, res, next) => {
  try {
    const { page = 1, limit = 10, status } = req.query;

    const query = { user: req.user._id };
    if (status) query.status = status;

    const pageNum = parseInt(page);
    const limitNum = parseInt(limit);
    const skip = (pageNum - 1) * limitNum;

    const orders = await Order.find(query)
      .populate('orderItems.product', 'name images')
      .sort({ createdAt: -1 })
      .skip(skip)
      .limit(limitNum);

    const count = await Order.countDocuments(query);

    res.json({
      success: true,
      data: {
        orders,
        pagination: {
          total: count,
          page: pageNum,
          pages: Math.ceil(count / limitNum),
          limit: limitNum
        }
      }
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get order by ID
 */
const getOrder = async (req, res, next) => {
  try {
    const { id } = req.params;

    const order = await Order.findById(id)
      .populate('user', 'name email phone')
      .populate('orderItems.product', 'name images')
      .populate('orderItems.seller', 'name businessName');

    if (!order) {
      return next(new AppError('Order not found', 404));
    }

    // Check ownership or admin/seller
    const isOwner = order.user._id.toString() === req.user._id.toString();
    const isAdmin = req.user.role === 'admin';
    const isSeller = order.orderItems.some(item => 
      item.seller._id.toString() === req.user._id.toString()
    );

    if (!isOwner && !isAdmin && !isSeller) {
      return next(new AppError('Not authorized to view this order', 403));
    }

    res.json({
      success: true,
      data: order
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Cancel order
 */
const cancelOrder = async (req, res, next) => {
  try {
    const { id } = req.params;
    const { reason } = req.body;

    const order = await Order.findById(id);

    if (!order) {
      return next(new AppError('Order not found', 404));
    }

    // Check ownership
    if (order.user.toString() !== req.user._id.toString()) {
      return next(new AppError('Not authorized to cancel this order', 403));
    }

    // Check if order can be cancelled
    if (!['pending', 'confirmed'].includes(order.status)) {
      return next(new AppError('Cannot cancel order that is already processing or delivered', 400));
    }

    // If paid, initiate refund
    if (order.isPaid && order.paymentDetails?.transactionId) {
      try {
        if (order.paymentGateway === 'stripe') {
          await stripeService.createRefund(order);
        } else if (order.paymentGateway === 'razorpay') {
          await razorpayService.createRefund(order);
        }
      } catch (refundError) {
        console.error('Refund error:', refundError);
      }
    }

    // Restore product stock
    for (const item of order.orderItems) {
      await Product.findByIdAndUpdate(item.product, {
        $inc: { stock: item.quantity }
      });
    }

    // Update order status
    order.status = 'cancelled';
    order.cancellationReason = reason;
    order.cancelledAt = new Date();
    order.cancelledBy = req.user._id;
    await order.save();

    res.json({
      success: true,
      message: 'Order cancelled successfully',
      data: order
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Request return
 */
const requestReturn = async (req, res, next) => {
  try {
    const { id } = req.params;
    const { reason } = req.body;

    const order = await Order.findById(id);

    if (!order) {
      return next(new AppError('Order not found', 404));
    }

    // Check ownership
    if (order.user.toString() !== req.user._id.toString()) {
      return next(new AppError('Not authorized', 403));
    }

    // Check if order can be returned
    if (order.status !== 'delivered') {
      return next(new AppError('Cannot return order that is not delivered', 400));
    }

    order.returnReason = reason;
    order.returnRequestedAt = new Date();
    order.status = 'return_requested';
    await order.save();

    res.json({
      success: true,
      message: 'Return request submitted',
      data: order
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Update order status (seller/admin only)
 */
const updateOrderStatus = async (req, res, next) => {
  try {
    const { id } = req.params;
    const { status, trackingNumber, shippingCarrier, estimatedDelivery } = req.body;

    const order = await Order.findById(id).populate('user', 'name email');

    if (!order) {
      return next(new AppError('Order not found', 404));
    }

    // Check if user is seller for this order
    const isSeller = order.orderItems.some(item => 
      item.seller.toString() === req.user._id.toString()
    );
    
    if (!isSeller && req.user.role !== 'admin') {
      return next(new AppError('Not authorized to update this order', 403));
    }

    order.status = status;
    
    if (trackingNumber) order.trackingNumber = trackingNumber;
    if (shippingCarrier) order.shippingCarrier = shippingCarrier;
    if (estimatedDelivery) order.estimatedDelivery = new Date(estimatedDelivery);

    if (status === 'delivered') {
      order.isDelivered = true;
      order.deliveredAt = new Date();
      sendOrderDelivered(order, order.user).catch(console.error);
    } else if (status === 'shipped') {
      sendOrderShipped(order, order.user).catch(console.error);
    }

    await order.save();

    res.json({
      success: true,
      data: order
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get all orders (admin/seller)
 */
const getAllOrders = async (req, res, next) => {
  try {
    const { page = 1, limit = 20, status, paymentStatus, sellerId } = req.query;

    const query = {};

    // For sellers, only show their orders
    if (req.user.role === 'seller') {
      query['orderItems.seller'] = req.user._id;
    }

    if (status) query.status = status;
    if (paymentStatus) query.paymentStatus = paymentStatus;
    if (sellerId) query['orderItems.seller'] = sellerId;

    const pageNum = parseInt(page);
    const limitNum = parseInt(limit);
    const skip = (pageNum - 1) * limitNum;

    const orders = await Order.find(query)
      .populate('user', 'name email phone')
      .populate('orderItems.seller', 'name businessName')
      .sort({ createdAt: -1 })
      .skip(skip)
      .limit(limitNum);

    const count = await Order.countDocuments(query);

    res.json({
      success: true,
      data: {
        orders,
        pagination: {
          total: count,
          page: pageNum,
          pages: Math.ceil(count / limitNum),
          limit: limitNum
        }
      }
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get order statistics (admin/seller)
 */
const getOrderStats = async (req, res, next) => {
  try {
    const { startDate, endDate } = req.query;

    const start = startDate ? new Date(startDate) : new Date(Date.now() - 30 * 24 * 60 * 60 * 1000);
    const end = endDate ? new Date(endDate) : new Date();

    const matchQuery = {
      createdAt: { $gte: start, $lte: end }
    };

    // For sellers, only show their orders
    if (req.user.role === 'seller') {
      matchQuery['orderItems.seller'] = req.user._id;
    }

    const stats = await Order.aggregate([
      { $match: matchQuery },
      {
        $group: {
          _id: null,
          totalOrders: { $sum: 1 },
          totalRevenue: { $sum: '$totalPrice' },
          totalItems: { $sum: { $size: '$orderItems' } },
          avgOrderValue: { $avg: '$totalPrice' }
        }
      }
    ]);

    // Status breakdown
    const statusBreakdown = await Order.aggregate([
      { $match: matchQuery },
      {
        $group: {
          _id: '$status',
          count: { $sum: 1 }
        }
      }
    ]);

    res.json({
      success: true,
      data: {
        summary: stats[0] || { totalOrders: 0, totalRevenue: 0, totalItems: 0, avgOrderValue: 0 },
        statusBreakdown: statusBreakdown.reduce((acc, s) => {
          acc[s._id] = s.count;
          return acc;
        }, {})
      }
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Create payment intent (Stripe)
 */
const createStripePaymentIntent = async (req, res, next) => {
  try {
    const { orderId } = req.body;

    const order = await Order.findById(orderId);
    if (!order) {
      return next(new AppError('Order not found', 404));
    }

    if (order.user.toString() !== req.user._id.toString()) {
      return next(new AppError('Not authorized', 403));
    }

    const result = await stripeService.createPaymentIntent(order);

    res.json({
      success: true,
      data: result
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Create Razorpay order
 */
const createRazorpayOrder = async (req, res, next) => {
  try {
    const { orderId } = req.body;

    const order = await Order.findById(orderId).populate('user', 'email');
    if (!order) {
      return next(new AppError('Order not found', 404));
    }

    if (order.user._id.toString() !== req.user._id.toString()) {
      return next(new AppError('Not authorized', 403));
    }

    const result = await razorpayService.createRazorpayOrder(order);

    res.json({
      success: true,
      data: result
    });
  } catch (error) {
    next(error);
  }
};

module.exports = {
  createOrder,
  getMyOrders,
  getOrder,
  cancelOrder,
  requestReturn,
  updateOrderStatus,
  getAllOrders,
  getOrderStats,
  createStripePaymentIntent,
  createRazorpayOrder
};