/**
 * Cart Controller
 * Handles shopping cart operations
 */

const Cart = require('../models/Cart');
const Product = require('../models/Product');
const Coupon = require('../models/Coupon');
const { AppError } = require('../middleware/errorHandler');

/**
 * Get user's cart
 */
const getCart = async (req, res, next) => {
  try {
    let cart = await Cart.findOne({ user: req.user._id })
      .populate({
        path: 'items.product',
        select: 'name price originalPrice images stock isActive finalPrice'
      });

    if (!cart) {
      cart = new Cart({ user: req.user._id, items: [] });
      await cart.save();
    }

    // Filter out inactive products
    cart.items = cart.items.filter(item => item.product && item.product.isActive);

    // Recalculate if needed
    cart.calculateTotals();
    await cart.save();

    res.json({
      success: true,
      data: cart
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Add item to cart
 */
const addToCart = async (req, res, next) => {
  try {
    const { productId, quantity = 1, color, size } = req.body;

    // Get product
    const product = await Product.findById(productId);

    if (!product || !product.isActive) {
      return next(new AppError('Product not found or unavailable', 404));
    }

    if (product.stock < quantity) {
      return next(new AppError('Insufficient stock', 400));
    }

    let cart = await Cart.findOne({ user: req.user._id });

    if (!cart) {
      cart = new Cart({ user: req.user._id, items: [] });
    }

    // Check if item exists
    const existingItemIndex = cart.items.findIndex(
      item => item.product.toString() === productId &&
             item.color === color &&
             item.size === size
    );

    if (existingItemIndex > -1) {
      // Update quantity
      const newQuantity = cart.items[existingItemIndex].quantity + quantity;
      if (newQuantity > product.stock) {
        return next(new AppError('Insufficient stock for requested quantity', 400));
      }
      cart.items[existingItemIndex].quantity = newQuantity;
    } else {
      // Add new item
      cart.items.push({
        product: productId,
        name: product.name,
        price: product.finalPrice || product.price,
        quantity,
        image: product.images[0]?.url || '',
        color,
        size,
        stock: product.stock
      });
    }

    cart.calculateTotals();
    await cart.save();

    res.json({
      success: true,
      data: cart
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Update cart item quantity
 */
const updateCartItem = async (req, res, next) => {
  try {
    const { productId, quantity, color, size } = req.body;

    const cart = await Cart.findOne({ user: req.user._id });

    if (!cart) {
      return next(new AppError('Cart not found', 404));
    }

    const itemIndex = cart.items.findIndex(
      item => item.product.toString() === productId &&
             item.color === color &&
             item.size === size
    );

    if (itemIndex === -1) {
      return next(new AppError('Item not found in cart', 404));
    }

    if (quantity === 0) {
      cart.items.splice(itemIndex, 1);
    } else {
      // Check stock
      const product = await Product.findById(productId);
      if (quantity > product.stock) {
        return next(new AppError('Insufficient stock', 400));
      }
      cart.items[itemIndex].quantity = quantity;
    }

    cart.calculateTotals();
    await cart.save();

    res.json({
      success: true,
      data: cart
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Remove item from cart
 */
const removeFromCart = async (req, res, next) => {
  try {
    const { productId, color, size } = req.params;

    const cart = await Cart.findOne({ user: req.user._id });

    if (!cart) {
      return next(new AppError('Cart not found', 404));
    }

    const itemIndex = cart.items.findIndex(
      item => item.product.toString() === productId &&
             item.color === color &&
             item.size === size
    );

    if (itemIndex > -1) {
      cart.items.splice(itemIndex, 1);
    } else {
      return next(new AppError('Item not found in cart', 404));
    }

    cart.calculateTotals();
    await cart.save();

    res.json({
      success: true,
      data: cart
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Clear cart
 */
const clearCart = async (req, res, next) => {
  try {
    const cart = await Cart.findOne({ user: req.user._id });

    if (cart) {
      cart.items = [];
      cart.appliedCoupon = null;
      cart.discountPrice = 0;
      cart.calculateTotals();
      await cart.save();
    }

    res.json({
      success: true,
      message: 'Cart cleared'
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Apply coupon
 */
const applyCoupon = async (req, res, next) => {
  try {
    const { code } = req.body;

    // Find coupon
    const coupon = await Coupon.findValidCoupon(code);

    if (!coupon) {
      return next(new AppError('Invalid or expired coupon', 400));
    }

    const cart = await Cart.findOne({ user: req.user._id })
      .populate({
        path: 'items.product',
        select: 'category'
      });

    if (!cart) {
      return next(new AppError('Cart not found', 404));
    }

    // Check minimum order value
    if (cart.itemsPrice < coupon.minOrderValue) {
      return next(new AppError(`Minimum order value of $${coupon.minOrderValue} required`, 400));
    }

    // Check if applicable to cart items
    const cartCategories = cart.items.map(item => item.product?.category);
    const cartProducts = cart.items.map(item => item.product?._id);

    const couponCheck = await coupon.appliesToCart(cart.itemsPrice, cartCategories, cartProducts);
    if (!couponCheck.valid) {
      return next(new AppError(couponCheck.message, 400));
    }

    // Check per user limit
    if (coupon.perUserLimit) {
      const previousUsage = await require('../models/Order').countDocuments({
        user: req.user._id,
        couponUsed: coupon._id
      });

      if (previousUsage >= coupon.perUserLimit) {
        return next(new AppError('Coupon usage limit reached', 400));
      }
    }

    // Apply coupon
    cart.appliedCoupon = coupon._id;
    cart.discountPrice = coupon.calculateDiscount(cart.itemsPrice);
    cart.calculateTotals();
    await cart.save();

    res.json({
      success: true,
      message: 'Coupon applied successfully',
      data: {
        coupon: coupon.code,
        discount: cart.discountPrice,
        totalPrice: cart.totalPrice
      }
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Remove coupon
 */
const removeCoupon = async (req, res, next) => {
  try {
    const cart = await Cart.findOne({ user: req.user._id });

    if (!cart) {
      return next(new AppError('Cart not found', 404));
    }

    cart.appliedCoupon = null;
    cart.discountPrice = 0;
    cart.calculateTotals();
    await cart.save();

    res.json({
      success: true,
      message: 'Coupon removed',
      data: cart
    });
  } catch (error) {
    next(error);
  }
};

module.exports = {
  getCart,
  addToCart,
  updateCartItem,
  removeFromCart,
  clearCart,
  applyCoupon,
  removeCoupon
};