/**
 * Cart Routes
 * Handles cart endpoints
 */

const express = require('express');
const router = express.Router();
const cartController = require('../controllers/cartController');
const { protect, customerOnly } = require('../middleware/auth');

// All cart routes require authentication
router.get('/', protect, cartController.getCart);
router.post('/add', protect, customerOnly, cartController.addToCart);
router.put('/item', protect, customerOnly, cartController.updateCartItem);
router.delete('/item/:productId', protect, cartController.removeFromCart);
router.delete('/clear', protect, cartController.clearCart);

// Coupon routes
router.post('/coupon/apply', protect, customerOnly, cartController.applyCoupon);
router.delete('/coupon/remove', protect, cartController.removeCoupon);

module.exports = router;