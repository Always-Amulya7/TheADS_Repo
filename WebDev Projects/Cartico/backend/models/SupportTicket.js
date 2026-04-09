/**
 * SupportTicket Model
 * Handles customer support tickets
 */

const mongoose = require('mongoose');

const ticketMessageSchema = new mongoose.Schema({
  sender: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User',
    required: true
  },
  message: {
    type: String,
    required: true
  },
  attachments: [{
    url: String,
    publicId: String,
    fileName: String
  }],
  isAdmin: {
    type: Boolean,
    default: false
  }
}, {
  timestamps: true
});

const supportTicketSchema = new mongoose.Schema({
  ticketNumber: {
    type: String,
    unique: true
  },
  user: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User',
    required: true
  },
  // Related order (optional)
  order: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Order'
  },
  // Related product (optional)
  product: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Product'
  },
  category: {
    type: String,
    enum: ['general', 'order', 'product', 'payment', 'refund', 'return', 'account', 'other'],
    default: 'general'
  },
  subject: {
    type: String,
    required: [true, 'Please provide a subject'],
    maxlength: 200
  },
  description: {
    type: String,
    required: [true, 'Please provide a description']
  },
  priority: {
    type: String,
    enum: ['low', 'medium', 'high', 'urgent'],
    default: 'medium'
  },
  status: {
    type: String,
    enum: ['open', 'pending', 'in_progress', 'resolved', 'closed'],
    default: 'open'
  },
  assignedTo: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User'
  },
  messages: [ticketMessageSchema],
  // Resolution
  resolution: String,
  resolvedAt: Date,
  resolvedBy: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User'
  },
  // Rating
  rating: {
    type: Number,
    min: 1,
    max: 5
  },
  feedback: String
}, {
  timestamps: true
});

// Indexes
supportTicketSchema.index({ ticketNumber: 1 });
supportTicketSchema.index({ user: 1, createdAt: -1 });
supportTicketSchema.index({ status: 1 });
supportTicketSchema.index({ assignedTo: 1 });

// Generate ticket number before saving
supportTicketSchema.pre('save', async function(next) {
  if (!this.ticketNumber) {
    const date = new Date();
    const timestamp = date.getFullYear().toString() + 
      (date.getMonth() + 1).toString().padStart(2, '0') + 
      date.getDate().toString().padStart(2, '0') +
      Math.floor(Math.random() * 10000).toString().padStart(4, '0');
    this.ticketNumber = 'TKT-' + timestamp;
  }
  next();
});

// Method to add message
supportTicketSchema.methods.addMessage = async function(userId, message, attachments = []) {
  this.messages.push({
    sender: userId,
    message,
    attachments,
    isAdmin: false
  });
  
  // Update status to pending if it was closed
  if (this.status === 'closed') {
    this.status = 'open';
  }
  
  await this.save();
  return this;
};

// Method to add admin response
supportTicketSchema.methods.addAdminResponse = async function(adminId, message, attachments = []) {
  this.messages.push({
    sender: adminId,
    message,
    attachments,
    isAdmin: true
  });
  
  this.status = 'pending';
  await this.save();
  return this;
};

// Method to resolve ticket
supportTicketSchema.methods.resolve = async function(adminId, resolution) {
  this.status = 'resolved';
  this.resolution = resolution;
  this.resolvedAt = new Date();
  this.resolvedBy = adminId;
  
  await this.save();
  return this;
};

module.exports = mongoose.model('SupportTicket', supportTicketSchema);