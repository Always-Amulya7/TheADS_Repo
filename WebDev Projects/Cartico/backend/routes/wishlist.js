/**
 * Wishlist Routes
 * Handles wishlist endpoints
 */

const express = require('express');
const router = express.Router();
const wishlistController = require('../controllers/wishlistController');
const { protect } = require('../middleware/auth');

// All wishlist routes require authentication
router.get('/', protect, wishlistController.getWishlist);
router.post('/add', protect, wishlistController.addToWishlist);
router.delete('/remove/:productId', protect, wishlistController.removeFromWishlist);
router.get('/check/:productId', protect, wishlistController.checkWishlist);
router.delete('/clear', protect, wishlistController.clearWishlist);

module.exports = router;