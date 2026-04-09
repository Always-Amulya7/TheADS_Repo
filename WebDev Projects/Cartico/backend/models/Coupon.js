/**
 * Coupon Model
 * Handles coupons and discount codes
 */

const mongoose = require('mongoose');

const couponSchema = new mongoose.Schema({
  code: {
    type: String,
    required: [true, 'Please provide a coupon code'],
    unique: true,
    uppercase: true,
    trim: true
  },
  description: String,
  // Discount type
  discountType: {
    type: String,
    enum: ['percentage', 'fixed'],
    required: true
  },
  discountValue: {
    type: Number,
    required: [true, 'Please provide a discount value'],
    min: 0
  },
  // Maximum discount cap
  maxDiscount: {
    type: Number,
    min: 0
  },
  // Minimum order value
  minOrderValue: {
    type: Number,
    default: 0,
    min: 0
  },
  // Usage limits
  usageLimit: {
    type: Number,
    default: null // null means unlimited
  },
  usageCount: {
    type: Number,
    default: 0
  },
  perUserLimit: {
    type: Number,
    default: 1
  },
  // Validity period
  startDate: {
    type: Date,
    required: true
  },
  endDate: {
    type: Date,
    required: true
  },
  // Applicable categories/products
  applicableCategories: [{
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Category'
  }],
  applicableProducts: [{
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Product'
  }],
  // Target users (specific users or all)
  targetUsers: [{
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User'
  }],
  // For new users only
  newUsersOnly: {
    type: Boolean,
    default: false
  },
  // Coupon status
  isActive: {
    type: Boolean,
    default: true
  },
  // Usage type
  usageType: {
    type: String,
    enum: ['general', 'first_order', 'specific_user', 'category'],
    default: 'general'
  },
  // Created by (for sellers)
  createdBy: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User'
  }
}, {
  timestamps: true
});

// Indexes (code has unique: true which auto-creates index)
couponSchema.index({ isActive: 1, startDate: 1, endDate: 1 });
couponSchema.index({ createdBy: 1 });

// Validate coupon is valid
couponSchema.methods.isValid = function() {
  const now = new Date();
  const isActive = this.isActive;
  const isWithinDate = now >= this.startDate && now <= this.endDate;
  const hasUsageLeft = this.usageLimit === null || this.usageCount < this.usageLimit;
  
  return isActive && isWithinDate && hasUsageLeft;
};

// Check if coupon applies to user
couponSchema.methods.appliesToUser = async function(userId, userOrderCount) {
  if (this.newUsersOnly && userOrderCount > 0) {
    return false;
  }
  
  if (this.targetUsers.length > 0) {
    return this.targetUsers.some(id => id.toString() === userId.toString());
  }
  
  return true;
};

// Check if coupon applies to cart
couponSchema.methods.appliesToCart = async function(cartTotal, categories, products) {
  if (cartTotal < this.minOrderValue) {
    return { valid: false, message: `Minimum order value of $${this.minOrderValue} required` };
  }
  
  if (this.applicableCategories.length > 0) {
    const hasCategory = categories.some(cat => 
      this.applicableCategories.some(id => id.toString() === cat.toString())
    );
    if (!hasCategory) {
      return { valid: false, message: 'Coupon not applicable to items in your cart' };
    }
  }
  
  if (this.applicableProducts.length > 0) {
    const hasProduct = products.some(prod => 
      this.applicableProducts.some(id => id.toString() === prod.toString())
    );
    if (!hasProduct) {
      return { valid: false, message: 'Coupon not applicable to items in your cart' };
    }
  }
  
  return { valid: true };
};

// Calculate discount
couponSchema.methods.calculateDiscount = function(cartTotal) {
  let discount = 0;
  
  if (this.discountType === 'percentage') {
    discount = (cartTotal * this.discountValue) / 100;
  } else {
    discount = this.discountValue;
  }
  
  if (this.maxDiscount && discount > this.maxDiscount) {
    discount = this.maxDiscount;
  }
  
  return discount;
};

// Static method to find valid coupon
couponSchema.statics.findValidCoupon = function(code) {
  return this.findOne({
    code: code.toUpperCase(),
    isActive: true,
    startDate: { $lte: new Date() },
    endDate: { $gte: new Date() }
  });
};

module.exports = mongoose.model('Coupon', couponSchema);