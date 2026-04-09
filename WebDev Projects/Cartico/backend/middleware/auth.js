/**
 * JWT Authentication Middleware
 * Handles access and refresh token generation and verification
 */

const jwt = require('jsonwebtoken');
const User = require('../models/User');

const JWT_SECRET = process.env.JWT_SECRET || 'cartico-secret-key-2024-secure';
const JWT_REFRESH_SECRET = process.env.JWT_REFRESH_SECRET || 'cartico-refresh-secret-key-2024-secure';
const JWT_EXPIRE = process.env.JWT_EXPIRE || '30d';
const JWT_REFRESH_EXPIRE = process.env.JWT_REFRESH_EXPIRE || '30d';

/**
 * Generate Access Token
 */
const generateAccessToken = (userId) => {
  return jwt.sign(
    { id: userId },
    JWT_SECRET,
    { expiresIn: JWT_EXPIRE }
  );
};

/**
 * Generate Refresh Token
 */
const generateRefreshToken = (userId) => {
  return jwt.sign(
    { id: userId },
    JWT_REFRESH_SECRET,
    { expiresIn: JWT_REFRESH_EXPIRE }
  );
};

/**
 * Generate both tokens
 */
const generateTokens = (userId) => {
  return {
    accessToken: generateAccessToken(userId),
    refreshToken: generateRefreshToken(userId)
  };
};

/**
 * Verify Access Token
 */
const verifyAccessToken = (token) => {
  return jwt.verify(token, JWT_SECRET);
};

/**
 * Verify Refresh Token
 */
const verifyRefreshToken = (token) => {
  return jwt.verify(token, JWT_REFRESH_SECRET);
};

/**
 * Middleware to protect routes - requires valid access token
 */
const protect = async (req, res, next) => {
  try {
    let token;

    // Get token from header
    if (req.headers.authorization && req.headers.authorization.startsWith('Bearer')) {
      token = req.headers.authorization.split(' ')[1];
    }

    if (!token) {
      return res.status(401).json({
        success: false,
        message: 'Not authorized to access this route'
      });
    }

    // Verify token
    const decoded = verifyAccessToken(token);

    // Get user
    const user = await User.findById(decoded.id).select('-password');

    if (!user) {
      return res.status(401).json({
        success: false,
        message: 'User not found'
      });
    }

    // Check if user is active
    if (!user.isActive) {
      return res.status(401).json({
        success: false,
        message: 'Account is deactivated'
      });
    }

    // Check if user is banned
    if (user.isBanned) {
      return res.status(403).json({
        success: false,
        message: 'Account is banned',
        banReason: user.banReason
      });
    }

    req.user = user;
    next();
  } catch (error) {
    if (error.name === 'TokenExpiredError') {
      return res.status(401).json({
        success: false,
        message: 'Token expired',
        code: 'TOKEN_EXPIRED'
      });
    }
    
    return res.status(401).json({
      success: false,
      message: 'Not authorized to access this route'
    });
  }
};

/**
 * Middleware to check if user is a customer
 */
const customerOnly = (req, res, next) => {
  if (req.user && req.user.role === 'customer') {
    next();
  } else {
    return res.status(403).json({
      success: false,
      message: 'Access denied. Customers only.'
    });
  }
};

/**
 * Middleware to check if user is a seller
 */
const sellerOnly = (req, res, next) => {
  if (req.user && (req.user.role === 'seller' || req.user.role === 'admin')) {
    // Check if seller is verified
    if (req.user.role === 'seller' && !req.user.isVerified) {
      return res.status(403).json({
        success: false,
        message: 'Your seller account is pending approval'
      });
    }
    next();
  } else {
    return res.status(403).json({
      success: false,
      message: 'Access denied. Sellers and admins only.'
    });
  }
};

/**
 * Middleware to check if user is an admin
 */
const adminOnly = (req, res, next) => {
  if (req.user && req.user.role === 'admin') {
    next();
  } else {
    return res.status(403).json({
      success: false,
      message: 'Access denied. Admins only.'
    });
  }
};

/**
 * Middleware to check if user is verified seller or admin
 */
const verifiedSellerOrAdmin = (req, res, next) => {
  if (req.user && (req.user.role === 'admin' || (req.user.role === 'seller' && req.user.isVerified))) {
    next();
  } else {
    return res.status(403).json({
      success: false,
      message: 'Verified seller or admin access required'
    });
  }
};

/**
 * Middleware to refresh access token
 */
const refreshToken = async (req, res, next) => {
  try {
    const { refreshToken } = req.body;

    if (!refreshToken) {
      return res.status(401).json({
        success: false,
        message: 'Refresh token required'
      });
    }

    // Verify refresh token
    const decoded = verifyRefreshToken(refreshToken);

    // Find user and check if refresh token matches
    const user = await User.findById(decoded.id);

    if (!user || user.refreshToken !== refreshToken) {
      return res.status(401).json({
        success: false,
        message: 'Invalid refresh token'
      });
    }

    // Generate new tokens
    const tokens = generateTokens(user._id);

    // Save new refresh token
    user.refreshToken = tokens.refreshToken;
    await user.save();

    // Add tokens to request
    req.tokens = tokens;
    req.user = user;
    next();
  } catch (error) {
    return res.status(401).json({
      success: false,
      message: 'Invalid refresh token'
    });
  }
};

module.exports = {
  generateAccessToken,
  generateRefreshToken,
  generateTokens,
  verifyAccessToken,
  verifyRefreshToken,
  protect,
  customerOnly,
  sellerOnly,
  adminOnly,
  verifiedSellerOrAdmin,
  refreshToken,
  JWT_SECRET,
  JWT_REFRESH_SECRET
};