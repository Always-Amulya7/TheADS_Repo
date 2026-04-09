/**
 * Wishlist Model
 * Handles user's wishlist functionality
 */

const mongoose = require('mongoose');

const wishlistItemSchema = new mongoose.Schema({
  product: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Product',
    required: true
  },
  addedAt: {
    type: Date,
    default: Date.now
  }
});

const wishlistSchema = new mongoose.Schema({
  user: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User',
    required: true,
    unique: true
  },
  items: [wishlistItemSchema]
}, {
  timestamps: true
});

// Index
wishlistSchema.index({ user: 1 });

// Add item to wishlist
wishlistSchema.methods.addItem = async function(productId) {
  const exists = this.items.find(
    item => item.product.toString() === productId.toString()
  );
  
  if (!exists) {
    this.items.push({ product: productId });
    await this.save();
  }
  
  return this;
};

// Remove item from wishlist
wishlistSchema.methods.removeItem = async function(productId) {
  this.items = this.items.filter(
    item => item.product.toString() !== productId.toString()
  );
  await this.save();
  return this;
};

// Check if product is in wishlist
wishlistSchema.methods.hasProduct = function(productId) {
  return this.items.some(
    item => item.product.toString() === productId.toString()
  );
};

module.exports = mongoose.model('Wishlist', wishlistSchema);