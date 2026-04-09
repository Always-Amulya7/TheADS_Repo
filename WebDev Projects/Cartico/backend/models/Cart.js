/**
 * Cart Model
 * Handles shopping cart functionality
 */

const mongoose = require('mongoose');

const cartItemSchema = new mongoose.Schema({
  product: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Product',
    required: true
  },
  name: {
    type: String,
    required: true
  },
  price: {
    type: Number,
    required: true
  },
  quantity: {
    type: Number,
    required: true,
    min: 1,
    default: 1
  },
  image: String,
  color: String,
  size: String,
  stock: {
    type: Number,
    default: 0
  }
});

const cartSchema = new mongoose.Schema({
  user: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User',
    required: true,
    unique: true,
    index: true
  },
  items: [cartItemSchema],
  itemsPrice: {
    type: Number,
    default: 0
  },
  shippingPrice: {
    type: Number,
    default: 0
  },
  taxPrice: {
    type: Number,
    default: 0
  },
  discountPrice: {
    type: Number,
    default: 0
  },
  totalPrice: {
    type: Number,
    default: 0
  },
  appliedCoupon: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Coupon'
  }
}, {
  timestamps: true
});

// Calculate cart totals
cartSchema.methods.calculateTotals = function(shippingConfig = {}) {
  this.itemsPrice = this.items.reduce((acc, item) => {
    return acc + (item.price * item.quantity);
  }, 0);
  
  // Free shipping threshold
  const freeShippingThreshold = shippingConfig.freeShippingThreshold || 55;
  const shippingCost = shippingConfig.shippingCost || 5.99;
  
  this.shippingPrice = this.itemsPrice > freeShippingThreshold ? 0 : shippingCost;
  
  // Tax calculation (8% by default)
  this.taxPrice = Math.round(this.itemsPrice * 0.08 * 100) / 100;
  
  // Final total
  this.totalPrice = this.itemsPrice + this.shippingPrice + this.taxPrice - this.discountPrice;
};

// Add item to cart
cartSchema.methods.addItem = async function(product, quantity = 1, variant = {}) {
  const existingItemIndex = this.items.findIndex(
    item => item.product.toString() === product._id.toString() && 
            item.color === variant.color && 
            item.size === variant.size
  );

  if (existingItemIndex > -1) {
    this.items[existingItemIndex].quantity += quantity;
  } else {
    this.items.push({
      product: product._id,
      name: product.name,
      price: product.finalPrice || product.price,
      quantity,
      image: product.images[0]?.url,
      color: variant.color,
      size: variant.size,
      stock: product.stock
    });
  }

  this.calculateTotals();
  await this.save();
  return this;
};

// Update item quantity
cartSchema.methods.updateQuantity = async function(productId, quantity, variant = {}) {
  const itemIndex = this.items.findIndex(
    item => item.product.toString() === productId.toString() && 
            item.color === variant.color && 
            item.size === variant.size
  );

  if (itemIndex === -1) {
    throw new Error('Item not found in cart');
  }

  if (quantity === 0) {
    this.items.splice(itemIndex, 1);
  } else {
    this.items[itemIndex].quantity = quantity;
  }

  this.calculateTotals();
  await this.save();
  return this;
};

// Remove item from cart
cartSchema.methods.removeItem = async function(productId, variant = {}) {
  const itemIndex = this.items.findIndex(
    item => item.product.toString() === productId.toString() && 
            item.color === variant.color && 
            item.size === variant.size
  );

  if (itemIndex > -1) {
    this.items.splice(itemIndex, 1);
  }

  this.calculateTotals();
  await this.save();
  return this;
};

// Clear cart
cartSchema.methods.clear = async function() {
  this.items = [];
  this.appliedCoupon = null;
  this.calculateTotals();
  await this.save();
  return this;
};

// Apply coupon
cartSchema.methods.applyCoupon = async function(coupon) {
  this.appliedCoupon = coupon._id;
  
  if (coupon.discountType === 'percentage') {
    this.discountPrice = (this.itemsPrice * coupon.discountValue) / 100;
  } else {
    this.discountPrice = coupon.discountValue;
  }
  
  // Cap discount if max discount exists
  if (coupon.maxDiscount && this.discountPrice > coupon.maxDiscount) {
    this.discountPrice = coupon.maxDiscount;
  }
  
  this.calculateTotals();
  await this.save();
  return this;
};

// Remove coupon
cartSchema.methods.removeCoupon = async function() {
  this.appliedCoupon = null;
  this.discountPrice = 0;
  this.calculateTotals();
  await this.save();
  return this;
};

module.exports = mongoose.model('Cart', cartSchema);