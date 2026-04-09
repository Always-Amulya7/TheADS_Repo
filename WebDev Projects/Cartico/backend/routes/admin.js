/**
 * Admin Routes
 * Handles admin endpoints
 */

const express = require('express');
const router = express.Router();
const adminController = require('../controllers/adminController');
const { protect, adminOnly } = require('../middleware/auth');

// Dashboard
router.get('/dashboard/stats', protect, adminOnly, adminController.getDashboardStats);
router.get('/analytics/sales', protect, adminOnly, adminController.getSalesAnalytics);

// User management
router.get('/users', protect, adminOnly, adminController.getUsers);
router.get('/users/:id', protect, adminOnly, adminController.getUser);
router.put('/users/:id', protect, adminOnly, adminController.updateUser);
router.put('/users/:id/ban', protect, adminOnly, adminController.toggleUserBan);

// Seller management
router.get('/sellers/pending', protect, adminOnly, adminController.getPendingSellers);
router.put('/sellers/:id/verify', protect, adminOnly, adminController.verifySeller);

// Categories
router.get('/categories', protect, adminOnly, adminController.manageCategories);

// Coupons
router.get('/coupons', protect, adminOnly, adminController.manageCoupons);

// Reviews
router.get('/reviews/pending', protect, adminOnly, adminController.getPendingReviews);
router.put('/reviews/:id/moderate', protect, adminOnly, adminController.moderateReview);

module.exports = router;