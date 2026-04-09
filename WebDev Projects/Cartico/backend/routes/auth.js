/**
 * Auth Routes
 * Handles user authentication endpoints
 */

const express = require('express');
const router = express.Router();
const authController = require('../controllers/authController');
const { protect, adminOnly, sellerOnly } = require('../middleware/auth');
const { validateRegister, validateLogin, validateUpdateProfile } = require('../middleware/validate');

// Public routes
router.post('/register', validateRegister, authController.register);
router.post('/login', validateLogin, authController.login);
router.post('/refresh-token', authController.refreshToken);
router.post('/forgot-password', authController.forgotPassword);
router.post('/reset-password', authController.resetPassword);
router.post('/verify-email', authController.verifyEmail);

// Protected routes
router.get('/profile', protect, authController.getProfile);
router.put('/profile', protect, validateUpdateProfile, authController.updateProfile);
router.put('/password', protect, authController.updatePassword);
router.post('/logout', protect, authController.logout);

module.exports = router;