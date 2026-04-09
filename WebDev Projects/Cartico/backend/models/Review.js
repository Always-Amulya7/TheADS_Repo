/**
 * Review Model
 * Handles product reviews and ratings
 */

const mongoose = require('mongoose');

const reviewSchema = new mongoose.Schema({
  product: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Product',
    required: true
  },
  user: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User',
    required: true
  },
  order: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Order'
  },
  rating: {
    type: Number,
    required: [true, 'Please provide a rating'],
    min: 1,
    max: 5
  },
  title: {
    type: String,
    maxlength: 200
  },
  comment: {
    type: String,
    required: [true, 'Please provide a review comment'],
    maxlength: 2000
  },
  // Review media
  images: [{
    url: String,
    publicId: String
  }],
  // Review helpfulness
  helpfulCount: {
    type: Number,
    default: 0
  },
  notHelpfulCount: {
    type: Number,
    default: 0
  },
  // Review verification
  isVerifiedPurchase: {
    type: Boolean,
    default: false
  },
  // Review status
  isApproved: {
    type: Boolean,
    default: false
  },
  isReported: {
    type: Boolean,
    default: false
  },
  reportReason: String,
  // Admin response
  adminResponse: String,
  adminResponseAt: Date,
  // Review attributes
  pros: [String],
  cons: [String]
}, {
  timestamps: true
});

// Indexes
reviewSchema.index({ product: 1, createdAt: -1 });
reviewSchema.index({ user: 1, product: 1 }, { unique: true });
reviewSchema.index({ isApproved: 1, createdAt: -1 });

// Pre-save to check for verified purchase
reviewSchema.pre('save', async function(next) {
  if (this.order) {
    const Order = mongoose.model('Order');
    const order = await Order.findOne({
      _id: this.order,
      user: this.user,
      status: 'delivered',
      isPaid: true
    });
    this.isVerifiedPurchase = !!order;
  }
  next();
});

// Static method to get product rating stats
reviewSchema.statics.getProductStats = async function(productId) {
  const stats = await this.aggregate([
    { $match: { product: mongoose.Types.ObjectId(productId), isApproved: true } },
    {
      $group: {
        _id: null,
        averageRating: { $avg: '$rating' },
        totalReviews: { $sum: 1 },
        ratingDistribution: {
          $push: '$rating'
        }
      }
    }
  ]);
  
  if (stats.length === 0) {
    return { averageRating: 0, totalReviews: 0, distribution: {} };
  }
  
  const distribution = { 1: 0, 2: 0, 3: 0, 4: 0, 5: 0 };
  stats[0].ratingDistribution.forEach(rating => {
    distribution[rating] = (distribution[rating] || 0) + 1;
  });
  
  return {
    averageRating: Math.round(stats[0].averageRating * 10) / 10,
    totalReviews: stats[0].totalReviews,
    distribution
  };
};

module.exports = mongoose.model('Review', reviewSchema);