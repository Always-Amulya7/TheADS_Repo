/**
 * Razorpay Payment Service
 * Handles Razorpay payment integration for India
 */

const Razorpay = require('razorpay');
const { AppError } = require('../middleware/errorHandler');
const Order = require('../models/Order');

// Initialize Razorpay only if credentials are available
let razorpay = null;
if (process.env.RAZORPAY_KEY_ID && process.env.RAZORPAY_KEY_SECRET) {
  razorpay = new Razorpay({
    key_id: process.env.RAZORPAY_KEY_ID,
    key_secret: process.env.RAZORPAY_KEY_SECRET
  });
}

/**
 * Check if Razorpay is configured
 */
const isRazorpayConfigured = () => {
  return razorpay !== null;
};

/**
 * Create Order (Razorpay Order)
 */
const createRazorpayOrder = async (order) => {
  try {
    const razorpayOrder = await razorpay.orders.create({
      amount: Math.round(order.totalPrice * 100), // Convert to paise
      currency: process.env.RAZORPAY_CURRENCY || 'INR',
      receipt: order.orderNumber,
      notes: {
        orderId: order._id.toString(),
        customerEmail: order.user.email
      }
    });

    return {
      orderId: razorpayOrder.id,
      amount: razorpayOrder.amount,
      currency: razorpayOrder.currency
    };
  } catch (error) {
    console.error('Razorpay order creation error:', error);
    throw new AppError('Failed to create Razorpay order', 500);
  }
};

/**
 * Verify Payment Signature
 */
const verifyPaymentSignature = async (options) => {
  const { razorpayOrderId, razorpayPaymentId, razorpaySignature } = options;

  try {
    const crypto = require('crypto');
    
    // Create signature
    const signature = crypto
      .createHmac('sha256', process.env.RAZORPAY_KEY_SECRET)
      .update(razorpayOrderId + '|' + razorpayPaymentId)
      .digest('hex');

    if (signature === razorpaySignature) {
      return true;
    } else {
      throw new AppError('Invalid payment signature', 400);
    }
  } catch (error) {
    throw new AppError('Failed to verify payment signature', 500);
  }
};

/**
 * Get Payment Details
 */
const getPaymentDetails = async (paymentId) => {
  try {
    const payment = await razorpay.payments.fetch(paymentId);
    return payment;
  } catch (error) {
    throw new AppError('Failed to get payment details', 500);
  }
};

/**
 * Handle Webhook
 */
const handleWebhook = async (req, res) => {
  const secret = process.env.RAZORPAY_WEBHOOK_SECRET;
  const crypto = require('crypto');
  
  const signature = req.headers['x-razorpay-signature'];
  
  // Verify signature
  const body = JSON.stringify(req.body);
  const expectedSignature = crypto
    .createHmac('sha256', secret)
    .update(body)
    .digest('hex');

  if (signature !== expectedSignature) {
    console.error('Invalid webhook signature');
    return res.status(400).json({ error: 'Invalid signature' });
  }

  const event = req.body;

  // Handle the event
  switch (event.event) {
    case 'payment.authorized':
      await handlePaymentAuthorized(event.payload.payment);
      break;
    case 'payment.captured':
      await handlePaymentCaptured(event.payload.payment);
      break;
    case 'payment.failed':
      await handlePaymentFailed(event.payload.payment);
      break;
    default:
      console.log(`Unhandled event type ${event.event}`);
  }

  res.json({ received: true });
};

/**
 * Handle Payment Authorized
 */
const handlePaymentAuthorized = async (payment) => {
  try {
    const orderId = payment.notes.orderId;
    const order = await Order.findById(orderId);

    if (order) {
      order.isPaid = true;
      order.paymentStatus = 'paid';
      order.paidAt = new Date();
      order.paymentDetails = {
        transactionId: payment.id,
        paymentId: payment.id,
        paymentDate: new Date(),
        upiId: payment.vpa || null
      };
      order.status = 'confirmed';
      await order.save();

      console.log(`Order ${order.orderNumber} payment authorized`);
    }
  } catch (error) {
    console.error('Error handling payment authorized:', error);
  }
};

/**
 * Handle Payment Captured
 */
const handlePaymentCaptured = async (payment) => {
  try {
    const orderId = payment.notes.orderId;
    const order = await Order.findById(orderId);

    if (order) {
      order.paymentStatus = 'paid';
      await order.save();

      console.log(`Order ${order.orderNumber} payment captured`);
    }
  } catch (error) {
    console.error('Error handling payment captured:', error);
  }
};

/**
 * Handle Payment Failed
 */
const handlePaymentFailed = async (payment) => {
  try {
    const orderId = payment.notes.orderId;
    const order = await Order.findById(orderId);

    if (order) {
      order.paymentStatus = 'failed';
      order.paymentDetails = {
        transactionId: payment.id,
        paymentDate: new Date(),
        failureMessage: payment.error_description
      };
      await order.save();

      console.log(`Order ${order.orderNumber} payment failed`);
    }
  } catch (error) {
    console.error('Error handling payment failed:', error);
  }
};

/**
 * Create Refund
 */
const createRefund = async (order, amount = null) => {
  try {
    const refundAmount = amount ? amount * 100 : order.totalPrice * 100;

    const refund = await razorpay.payments.refund(order.paymentDetails.paymentId, {
      amount: refundAmount,
      notes: {
        reason: 'Customer requested refund'
      }
    });

    order.paymentStatus = 'refunded';
    order.refundAmount = amount || order.totalPrice;
    order.refundMethod = 'razorpay';
    await order.save();

    return refund;
  } catch (error) {
    console.error('Razorpay refund error:', error);
    throw new AppError('Failed to process refund', 500);
  }
};

/**
 * Create UPI Payment Link
 */
const createUpiPaymentLink = async (order, user) => {
  try {
    const paymentLink = await razorpay.paymentLink.create({
      amount: Math.round(order.totalPrice * 100),
      currency: process.env.RAZORPAY_CURRENCY || 'INR',
      description: `Order ${order.orderNumber}`,
      customer: {
        email: user.email,
        contact: user.phone
      },
      notify: {
        email: true,
        sms: true
      },
      notes: {
        orderId: order._id.toString()
      }
    });

    return {
      paymentLinkId: paymentLink.id,
      paymentUrl: paymentLink.short_url
    };
  } catch (error) {
    console.error('UPI payment link creation error:', error);
    throw new AppError('Failed to create UPI payment link', 500);
  }
};

module.exports = {
  createRazorpayOrder,
  verifyPaymentSignature,
  getPaymentDetails,
  handleWebhook,
  createRefund,
  createUpiPaymentLink
};