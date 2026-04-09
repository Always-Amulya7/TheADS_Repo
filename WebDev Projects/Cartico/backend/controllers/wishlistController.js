/**
 * Wishlist Controller
 * Handles user's wishlist operations
 */

const Wishlist = require('../models/Wishlist');
const Product = require('../models/Product');
const { AppError } = require('../middleware/errorHandler');

/**
 * Get user's wishlist
 */
const getWishlist = async (req, res, next) => {
  try {
    let wishlist = await Wishlist.findOne({ user: req.user._id })
      .populate({
        path: 'items.product',
        select: 'name price originalPrice images ratings numReviews isActive finalPrice'
      });

    if (!wishlist) {
      wishlist = new Wishlist({ user: req.user._id, items: [] });
      await wishlist.save();
    }

    // Filter out inactive products
    wishlist.items = wishlist.items.filter(item => item.product && item.product.isActive);

    res.json({
      success: true,
      data: wishlist
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Add to wishlist
 */
const addToWishlist = async (req, res, next) => {
  try {
    const { productId } = req.body;

    const product = await Product.findById(productId);
    if (!product || !product.isActive) {
      return next(new AppError('Product not found or unavailable', 404));
    }

    let wishlist = await Wishlist.findOne({ user: req.user._id });

    if (!wishlist) {
      wishlist = new Wishlist({ user: req.user._id, items: [] });
    }

    // Check if already exists
    const exists = wishlist.items.some(
      item => item.product.toString() === productId
    );

    if (exists) {
      return next(new AppError('Product already in wishlist', 400));
    }

    await wishlist.addItem(productId);

    res.json({
      success: true,
      message: 'Added to wishlist',
      data: wishlist
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Remove from wishlist
 */
const removeFromWishlist = async (req, res, next) => {
  try {
    const { productId } = req.params;

    const wishlist = await Wishlist.findOne({ user: req.user._id });

    if (!wishlist) {
      return next(new AppError('Wishlist not found', 404));
    }

    await wishlist.removeItem(productId);

    res.json({
      success: true,
      message: 'Removed from wishlist',
      data: wishlist
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Check if product is in wishlist
 */
const checkWishlist = async (req, res, next) => {
  try {
    const { productId } = req.params;

    const wishlist = await Wishlist.findOne({ user: req.user._id });

    const isInWishlist = wishlist ? wishlist.hasProduct(productId) : false;

    res.json({
      success: true,
      data: { isInWishlist }
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Clear wishlist
 */
const clearWishlist = async (req, res, next) => {
  try {
    const wishlist = await Wishlist.findOne({ user: req.user._id });

    if (wishlist) {
      wishlist.items = [];
      await wishlist.save();
    }

    res.json({
      success: true,
      message: 'Wishlist cleared'
    });
  } catch (error) {
    next(error);
  }
};

module.exports = {
  getWishlist,
  addToWishlist,
  removeFromWishlist,
  checkWishlist,
  clearWishlist
};