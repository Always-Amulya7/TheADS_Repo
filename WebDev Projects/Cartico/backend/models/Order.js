/**
 * Order Model
 * Handles order data, items, and status tracking
 */

const mongoose = require('mongoose');

const orderItemSchema = new mongoose.Schema({
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
    min: 1
  },
  image: String,
  color: String,
  size: String,
  seller: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User',
    required: true
  }
});

const orderSchema = new mongoose.Schema({
  orderNumber: {
    type: String,
    unique: true,
    index: true
  },
  user: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User',
    required: true,
    index: true
  },
  orderItems: [orderItemSchema],
  shippingAddress: {
    fullName: {
      type: String,
      required: true
    },
    phone: {
      type: String,
      required: true
    },
    address: {
      street: String,
      city: String,
      state: String,
      zipCode: String,
      country: String
    }
  },
  // Payment details
  paymentMethod: {
    type: String,
    enum: ['card', 'cod', 'paypal', 'stripe', 'razorpay', 'upi', 'wallet'],
    required: true
  },
  paymentGateway: {
    type: String,
    enum: ['stripe', 'razorpay', 'paypal', 'none'],
    default: 'none'
  },
  paymentStatus: {
    type: String,
    enum: ['pending', 'paid', 'failed', 'refunded', 'partially_refunded'],
    default: 'pending'
  },
  paymentDetails: {
    transactionId: String,
    paymentId: String,
    paymentDate: Date,
    cardLast4: String,
    cardBrand: String,
    upiId: String,
    walletType: String
  },
  // Pricing
  itemsPrice: {
    type: Number,
    required: true
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
    required: true
  },
  // Order status
  status: {
    type: String,
    enum: ['pending', 'confirmed', 'processing', 'shipped', 'delivered', 'cancelled', 'returned'],
    default: 'pending'
  },
  // Payment flags
  isPaid: {
    type: Boolean,
    default: false
  },
  paidAt: Date,
  isDelivered: {
    type: Boolean,
    default: false
  },
  deliveredAt: Date,
  // Shipping
  trackingNumber: String,
  shippingCarrier: String,
  shippingMethod: String,
  estimatedDelivery: Date,
  // Order notes
  notes: String,
  adminNotes: String,
  // Cancellation/Return
  cancellationReason: String,
  cancelledAt: Date,
  cancelledBy: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User'
  },
  returnReason: String,
  returnRequestedAt: Date,
  returnApprovedAt: Date,
  returnRejectedAt: Date,
  returnCompletedAt: Date,
  refundAmount: Number,
  refundMethod: String,
  // Invoice
  invoiceNumber: String,
  invoiceUrl: String,
  // Coupon used
  couponUsed: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Coupon'
  },
  couponDiscount: {
    type: Number,
    default: 0
  }
}, {
  timestamps: true,
  toJSON: { virtuals: true },
  toObject: { virtuals: true }
});

// Indexes
orderSchema.index({ user: 1, createdAt: -1 });
orderSchema.index({ seller: 1, createdAt: -1 });
orderSchema.index({ status: 1 });
orderSchema.index({ paymentStatus: 1 });
orderSchema.index({ 'orderItems.product': 1 });

// Generate order number before saving
orderSchema.pre('save', async function(next) {
  if (!this.orderNumber) {
    const date = new Date();
    const timestamp = date.getFullYear().toString() + 
      (date.getMonth() + 1).toString().padStart(2, '0') + 
      date.getDate().toString().padStart(2, '0') +
      Math.floor(Math.random() * 10000).toString().padStart(4, '0');
    this.orderNumber = 'CART-' + timestamp;
  }
  
  // Generate invoice number
  if (!this.invoiceNumber) {
    this.invoiceNumber = 'INV-' + this.orderNumber;
  }
  
  next();
});

// Virtual for order status display
orderSchema.virtual('statusDisplay').get(function() {
  const statusMap = {
    pending: 'Pending',
    confirmed: 'Confirmed',
    processing: 'Processing',
    shipped: 'Shipped',
    delivered: 'Delivered',
    cancelled: 'Cancelled',
    returned: 'Returned'
  };
  return statusMap[this.status] || this.status;
});

// Virtual for can cancel
orderSchema.virtual('canCancel').get(function() {
  return ['pending', 'confirmed'].includes(this.status) && !this.isPaid;
});

// Virtual for can return
orderSchema.virtual('canReturn').get(function() {
  return this.status === 'delivered' && !this.returnRequestedAt;
});

// Method to update status
orderSchema.methods.updateStatus = async function(status, notes) {
  this.status = status;
  if (notes) this.adminNotes = notes;
  
  if (status === 'delivered') {
    this.isDelivered = true;
    this.deliveredAt = new Date();
  }
  
  if (status === 'cancelled') {
    this.cancelledAt = new Date();
  }
  
  await this.save();
  return this;
};

// Method to process refund
orderSchema.methods.processRefund = async function(amount, method) {
  this.paymentStatus = 'refunded';
  this.refundAmount = amount;
  this.refundMethod = method;
  await this.save();
  return this;
};

// Static method to get orders by seller
orderSchema.statics.getBySeller = function(sellerId, options = {}) {
  return this.find({ 'orderItems.seller': sellerId })
    .populate('user', 'name email phone')
    .sort({ createdAt: -1 })
    .skip(options.skip || 0)
    .limit(options.limit || 20);
};

// Static method for analytics
orderSchema.statics.getAnalytics = async function(startDate, endDate) {
  return this.aggregate([
    {
      $match: {
        createdAt: { $gte: startDate, $lte: endDate }
      }
    },
    {
      $group: {
        _id: {
          $dateToString: { format: '%Y-%m-%d', date: '$createdAt' }
        },
        totalOrders: { $sum: 1 },
        totalRevenue: { $sum: '$totalPrice' },
        totalItems: { $sum: { $size: '$orderItems' } }
      }
    },
    { $sort: { _id: 1 } }
  ]);
};

module.exports = mongoose.model('Order', orderSchema);
