/**
 * Review Controller
 * Handles product reviews and ratings
 */

const Review = require('../models/Review');
const Product = require('../models/Product');
const Order = require('../models/Order');
const { AppError } = require('../middleware/errorHandler');

/**
 * Get product reviews
 */
const getProductReviews = async (req, res, next) => {
  try {
    const { productId } = req.params;
    const { page = 1, limit = 10, sort = '-createdAt' } = req.query;

    const pageNum = parseInt(page);
    const limitNum = parseInt(limit);
    const skip = (pageNum - 1) * limitNum;

    const reviews = await Review.find({ product: productId, isApproved: true })
      .populate('user', 'name avatar')
      .sort(sort)
      .skip(skip)
      .limit(limitNum);

    const count = await Review.countDocuments({ product: productId, isApproved: true });

    // Get rating stats
    const stats = await Review.getProductStats(productId);

    res.json({
      success: true,
      data: {
        reviews,
        stats,
        pagination: {
          total: count,
          page: pageNum,
          pages: Math.ceil(count / limitNum),
          limit: limitNum
        }
      }
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Create review (verified purchase only)
 */
const createReview = async (req, res, next) => {
  try {
    const { productId, rating, title, comment, images, pros, cons, orderId } = req.body;

    // Check if user has purchased the product
    if (orderId) {
      const order = await Order.findOne({
        _id: orderId,
        user: req.user._id,
        status: 'delivered',
        isPaid: true
      });

      if (!order) {
        return next(new AppError('You can only review products from delivered orders', 400));
      }

      // Check if product is in the order
      const hasProduct = order.orderItems.some(
        item => item.product.toString() === productId
      );

      if (!hasProduct) {
        return next(new AppError('Product not found in the specified order', 400));
      }
    } else {
      // Check if user has any delivered order with this product
      const orders = await Order.find({
        user: req.user._id,
        status: 'delivered',
        isPaid: true,
        'orderItems.product': productId
      });

      if (orders.length === 0) {
        return next(new AppError('You can only review products you have purchased', 400));
      }
    }

    // Check if already reviewed
    const existingReview = await Review.findOne({
      user: req.user._id,
      product: productId
    });

    if (existingReview) {
      return next(new AppError('You have already reviewed this product', 400));
    }

    const review = await Review.create({
      user: req.user._id,
      product: productId,
      rating,
      title,
      comment,
      images,
      pros,
      cons,
      order: orderId || undefined,
      isApproved: false // Requires admin approval
    });

    res.status(201).json({
      success: true,
      message: 'Review submitted successfully. It will be visible after approval.',
      data: review
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Update review
 */
const updateReview = async (req, res, next) => {
  try {
    const { id } = req.params;
    const { rating, title, comment, images, pros, cons } = req.body;

    const review = await Review.findById(id);

    if (!review) {
      return next(new AppError('Review not found', 404));
    }

    // Only the author can update
    if (review.user.toString() !== req.user._id.toString()) {
      return next(new AppError('Not authorized to update this review', 403));
    }

    // Can't update if already approved
    if (review.isApproved) {
      return next(new AppError('Cannot update an approved review', 400));
    }

    review.rating = rating || review.rating;
    review.title = title || review.title;
    review.comment = comment || review.comment;
    review.images = images || review.images;
    review.pros = pros || review.pros;
    review.cons = cons || review.cons;

    await review.save();

    res.json({
      success: true,
      data: review
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Delete review
 */
const deleteReview = async (req, res, next) => {
  try {
    const { id } = req.params;

    const review = await Review.findById(id);

    if (!review) {
      return next(new AppError('Review not found', 404));
    }

    // Only author or admin can delete
    if (review.user.toString() !== req.user._id.toString() && req.user.role !== 'admin') {
      return next(new AppError('Not authorized to delete this review', 403));
    }

    await review.deleteOne();

    // Update product rating
    const product = await Product.findById(review.product);
    if (product) {
      await product.updateRating();
    }

    res.json({
      success: true,
      message: 'Review deleted'
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get my reviews
 */
const getMyReviews = async (req, res, next) => {
  try {
    const { page = 1, limit = 10 } = req.query;

    const pageNum = parseInt(page);
    const limitNum = parseInt(limit);
    const skip = (pageNum - 1) * limitNum;

    const reviews = await Review.find({ user: req.user._id })
      .populate('product', 'name images')
      .sort({ createdAt: -1 })
      .skip(skip)
      .limit(limitNum);

    const count = await Review.countDocuments({ user: req.user._id });

    res.json({
      success: true,
      data: {
        reviews,
        pagination: {
          total: count,
          page: pageNum,
          pages: Math.ceil(count / limitNum),
          limit: limitNum
        }
      }
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Mark review as helpful/not helpful
 */
const markReviewHelpful = async (req, res, next) => {
  try {
    const { id } = req.params;
    const { helpful } = req.body;

    const review = await Review.findById(id);

    if (!review) {
      return next(new AppError('Review not found', 404));
    }

    if (helpful) {
      review.helpfulCount += 1;
    } else {
      review.notHelpfulCount += 1;
    }

    await review.save();

    res.json({
      success: true,
      data: {
        helpfulCount: review.helpfulCount,
        notHelpfulCount: review.notHelpfulCount
      }
    });
  } catch (error) {
    next(error);
  }
};

module.exports = {
  getProductReviews,
  createReview,
  updateReview,
  deleteReview,
  getMyReviews,
  markReviewHelpful
};