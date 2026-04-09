/**
 * Product Routes
 * Handles product endpoints
 */

const express = require('express');
const router = express.Router();
const productController = require('../controllers/productController');
const { protect, sellerOnly, adminOnly } = require('../middleware/auth');
const { validateProduct } = require('../middleware/validate');
const { handleUpload, uploadProductImages } = require('../middleware/upload');

// Public routes
router.get('/', productController.getProducts);
router.get('/featured', productController.getFeaturedProducts);
router.get('/flash-sale', productController.getFlashSaleProducts);
router.get('/category/:category', productController.getProducts);
router.get('/:id', productController.getProduct);
router.get('/slug/:slug', productController.getProductBySlug);
router.get('/:id/related', productController.getRelatedProducts);

// Protected routes - Seller
router.get('/seller/my-products', protect, sellerOnly, productController.getSellerProducts);
router.post('/', protect, sellerOnly, validateProduct, productController.createProduct);
router.put('/:id', protect, sellerOnly, productController.updateProduct);
router.delete('/:id', protect, sellerOnly, productController.deleteProduct);
router.put('/:id/stock', protect, sellerOnly, productController.updateStock);

// Protected routes - Admin
router.get('/admin/analytics', protect, adminOnly, productController.getSellerAnalytics);

module.exports = router;