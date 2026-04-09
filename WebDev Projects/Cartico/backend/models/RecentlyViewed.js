/**
 * RecentlyViewed Model
 * Tracks user's recently viewed products
 */

const mongoose = require('mongoose');

const recentlyViewedSchema = new mongoose.Schema({
  user: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User',
    required: true,
    unique: true
  },
  products: [{
    product: {
      type: mongoose.Schema.Types.ObjectId,
      ref: 'Product'
    },
    viewedAt: {
      type: Date,
      default: Date.now
    }
  }],
  maxProducts: {
    type: Number,
    default: 20
  }
}, {
  timestamps: true
});

// Index
recentlyViewedSchema.index({ user: 1 });

// Add product to recently viewed
recentlyViewedSchema.methods.addProduct = async function(productId) {
  // Check if product already exists
  const existingIndex = this.products.findIndex(
    p => p.product.toString() === productId.toString()
  );
  
  if (existingIndex > -1) {
    // Update viewed time
    this.products[existingIndex].viewedAt = new Date();
    // Move to front
    const product = this.products.splice(existingIndex, 1)[0];
    this.products.unshift(product);
  } else {
    // Add new product
    this.products.unshift({ product: productId, viewedAt: new Date() });
    
    // Remove oldest if exceeds max
    if (this.products.length > this.maxProducts) {
      this.products.pop();
    }
  }
  
  await this.save();
  return this;
};

// Get recent products
recentlyViewedSchema.methods.getRecentProducts = function(limit = 10) {
  return this.products
    .sort((a, b) => b.viewedAt - a.viewedAt)
    .slice(0, limit)
    .map(p => p.product);
};

module.exports = mongoose.model('RecentlyViewed', recentlyViewedSchema);