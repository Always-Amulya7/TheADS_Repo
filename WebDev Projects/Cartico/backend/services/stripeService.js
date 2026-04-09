/**
 * Stripe Payment Service
 * Handles Stripe payment integration
 */

let stripe = null;
if (process.env.STRIPE_SECRET_KEY && process.env.STRIPE_SECRET_KEY.startsWith('sk_')) {
  stripe = require('stripe')(process.env.STRIPE_SECRET_KEY);
}

const { AppError } = require('../middleware/errorHandler');
const Order = require('../models/Order');

/**
 * Check if Stripe is configured
 */
const isStripeConfigured = () => {
  return stripe !== null;
};

/**
 * Create Stripe Customer
 */
const createCustomer = async (email, name) => {
  if (!stripe) {
    console.warn('Stripe is not configured. Payment features unavailable.');
    return null;
  }
  try {
    const customer = await stripe.customers.create({
      email,
      name
    });
    return customer;
  } catch (error) {
    throw new AppError('Failed to create Stripe customer', 500);
  }
};

/**
 * Create Payment Intent
 */
const createPaymentIntent = async (order) => {
  if (!stripe) {
    console.warn('Stripe is not configured. Payment features unavailable.');
    return null;
  }
  try {
    const paymentIntent = await stripe.paymentIntents.create({
      amount: Math.round(order.totalPrice * 100), // Convert to cents
      currency: process.env.STRIPE_CURRENCY || 'usd',
      metadata: {
        orderId: order._id.toString(),
        orderNumber: order.orderNumber,
        customerEmail: order.user.email
      },
      receipt_email: order.user.email,
      metadata: {
        orderId: order._id.toString()
      }
    });

    return {
      clientSecret: paymentIntent.client_secret,
      paymentIntentId: paymentIntent.id
    };
  } catch (error) {
    throw new AppError('Failed to create payment intent', 500);
  }
};

/**
 * Confirm Payment
 */
const confirmPayment = async (paymentIntentId) => {
  try {
    const paymentIntent = await stripe.paymentIntents.retrieve(paymentIntentId);
    return paymentIntent;
  } catch (error) {
    throw new AppError('Failed to confirm payment', 500);
  }
};

/**
 * Handle Webhook
 */
const handleWebhook = async (req, res) => {
  const sig = req.headers['stripe-signature'];
  let event;

  try {
    event = stripe.webhooks.constructEvent(
      req.body,
      sig,
      process.env.STRIPE_WEBHOOK_SECRET
    );
  } catch (err) {
    console.error(`Webhook signature verification failed.`, err.message);
    return res.status(400).send(`Webhook Error: ${err.message}`);
  }

  // Handle the event
  switch (event.type) {
    case 'payment_intent.succeeded':
      const paymentIntent = event.data.object;
      await handlePaymentSuccess(paymentIntent);
      break;
    case 'payment_intent.payment_failed':
      const failedPayment = event.data.object;
      await handlePaymentFailure(failedPayment);
      break;
    default:
      console.log(`Unhandled event type ${event.type}`);
  }

  res.json({ received: true });
};

/**
 * Handle Payment Success
 */
const handlePaymentSuccess = async (paymentIntent) => {
  try {
    const orderId = paymentIntent.metadata.orderId;
    const order = await Order.findById(orderId);

    if (order) {
      order.isPaid = true;
      order.paymentStatus = 'paid';
      order.paidAt = new Date();
      order.paymentDetails = {
        transactionId: paymentIntent.id,
        paymentId: paymentIntent.id,
        paymentDate: new Date(),
        cardLast4: paymentIntent.payment_method_details?.card?.last4 || '****',
        cardBrand: paymentIntent.payment_method_details?.card?.brand || 'unknown'
      };
      order.status = 'confirmed';
      await order.save();

      console.log(`Order ${order.orderNumber} payment successful`);
    }
  } catch (error) {
    console.error('Error handling payment success:', error);
  }
};

/**
 * Handle Payment Failure
 */
const handlePaymentFailure = async (paymentIntent) => {
  try {
    const orderId = paymentIntent.metadata.orderId;
    const order = await Order.findById(orderId);

    if (order) {
      order.paymentStatus = 'failed';
      order.paymentDetails = {
        transactionId: paymentIntent.id,
        paymentDate: new Date(),
        failureMessage: paymentIntent.last_payment_error?.message
      };
      await order.save();

      console.log(`Order ${order.orderNumber} payment failed`);
    }
  } catch (error) {
    console.error('Error handling payment failure:', error);
  }
};

/**
 * Create Refund
 */
const createRefund = async (order, amount = null) => {
  try {
    const refundAmount = amount || Math.round(order.totalPrice * 100);

    const refund = await stripe.refunds.create({
      payment_intent: order.paymentDetails.transactionId,
      amount: refundAmount
    });

    order.paymentStatus = 'refunded';
    order.refundAmount = amount ? amount / 100 : order.totalPrice;
    order.refundMethod = 'stripe';
    await order.save();

    return refund;
  } catch (error) {
    throw new AppError('Failed to process refund', 500);
  }
};

/**
 * Get Card Brand from Payment Method
 */
const getCardBrand = (paymentMethodId) => {
  return stripe.paymentMethods.retrieve(paymentMethodId)
    .then(pm => pm.card.brand)
    .catch(() => 'unknown');
};

module.exports = {
  createCustomer,
  createPaymentIntent,
  confirmPayment,
  handleWebhook,
  createRefund,
  getCardBrand
};