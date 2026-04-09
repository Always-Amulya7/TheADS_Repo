/**
 * Review Routes
 * Handles review endpoints
 */

const express = require('express');
const router = express.Router();
const reviewController = require('../controllers/reviewController');
const { protect } = require('../middleware/auth');

// Public routes
router.get('/product/:productId', reviewController.getProductReviews);

// Protected routes
router.get('/my-reviews', protect, reviewController.getMyReviews);
router.post('/', protect, reviewController.createReview);
router.put('/:id', protect, reviewController.updateReview);
router.delete('/:id', protect, reviewController.deleteReview);
router.put('/:id/helpful', protect, reviewController.markReviewHelpful);

module.exports = router;