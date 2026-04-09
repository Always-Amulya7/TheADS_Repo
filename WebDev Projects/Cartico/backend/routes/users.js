/**
 * User Routes (Backward Compatibility)
 * Maps old /api/users/* endpoints to new /api/cart/* endpoints
 */

const express = require('express');
const router = express.Router();
const cartController = require('../controllers/cartController');
const { protect } = require('../middleware/auth');

// Cart endpoints - mapped from old /api/users/cart to /api/cart
router.get('/cart', protect, cartController.getCart);
router.post('/cart/add', protect, cartController.addToCart);
router.put('/cart/update', protect, cartController.updateCartItem);
router.delete('/cart/remove/:productId', protect, cartController.removeFromCart);
router.delete('/cart/clear', protect, cartController.clearCart);
router.post('/cart/coupon/apply', protect, cartController.applyCoupon);
router.delete('/cart/coupon/remove', protect, cartController.removeCoupon);

// Legacy address endpoint
router.put('/address', protect, async (req, res) => {
  res.json({ success: true, message: 'Address updated', address: req.body.address });
});

module.exports = router;