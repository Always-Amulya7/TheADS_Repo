/**
 * Category Routes
 * Handles category endpoints
 */

const express = require('express');
const router = express.Router();
const categoryController = require('../controllers/categoryController');
const { protect, adminOnly } = require('../middleware/auth');
const { validateCategory } = require('../middleware/validate');

// Public routes
router.get('/', categoryController.getCategories);
router.get('/tree', categoryController.getCategoryTree);
router.get('/popular', categoryController.getPopularCategories);
router.get('/slug/:slug', categoryController.getCategoryBySlug);
router.get('/:slug/products', categoryController.getCategoryWithProducts);
router.get('/:id', categoryController.getCategory);
router.get('/parent/:parentId/subcategories', categoryController.getSubcategories);

// Protected routes - Admin
router.post('/', protect, adminOnly, validateCategory, categoryController.createCategory);
router.put('/:id', protect, adminOnly, categoryController.updateCategory);
router.delete('/:id', protect, adminOnly, categoryController.deleteCategory);

module.exports = router;