/**
 * Order Routes
 * Handles order endpoints
 */

const express = require('express');
const router = express.Router();
const orderController = require('../controllers/orderController');
const { protect, customerOnly, sellerOnly, adminOnly } = require('../middleware/auth');
const { validateOrder } = require('../middleware/validate');

// Public routes
// None - all order routes require authentication

// Protected routes - Customer
router.post('/', protect, customerOnly, validateOrder, orderController.createOrder);
router.get('/my-orders', protect, orderController.getMyOrders);
router.get('/:id', protect, orderController.getOrder);
router.put('/:id/cancel', protect, customerOnly, orderController.cancelOrder);
router.put('/:id/return', protect, customerOnly, orderController.requestReturn);

// Payment endpoints
router.post('/payment/stripe-intent', protect, customerOnly, orderController.createStripePaymentIntent);
router.post('/payment/razorpay-order', protect, customerOnly, orderController.createRazorpayOrder);

// Protected routes - Seller/Admin
router.get('/seller/all', protect, sellerOnly, orderController.getAllOrders);
router.put('/:id/status', protect, sellerOnly, orderController.updateOrderStatus);
router.get('/seller/stats', protect, sellerOnly, orderController.getOrderStats);

module.exports = router;