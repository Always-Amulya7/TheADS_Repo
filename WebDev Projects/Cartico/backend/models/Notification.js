/**
 * Notification Model
 * Handles user notifications
 */

const mongoose = require('mongoose');

const notificationSchema = new mongoose.Schema({
  user: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'User',
    required: true
  },
  type: {
    type: String,
    enum: ['order', 'payment', 'product', 'review', 'support', 'promotion', 'system'],
    required: true
  },
  title: {
    type: String,
    required: true,
    maxlength: 200
  },
  message: {
    type: String,
    required: true
  },
  // Related entity
  relatedEntity: {
    type: String,
    enum: ['order', 'product', 'review', 'ticket', 'coupon', 'user', null],
    default: null
  },
  relatedEntityId: {
    type: mongoose.Schema.Types.ObjectId
  },
  // Notification status
  isRead: {
    type: Boolean,
    default: false
  },
  readAt: Date,
  // Action URL (for clickable notifications)
  actionUrl: String,
  // Additional data
  data: {
    type: mongoose.Schema.Types.Mixed
  }
}, {
  timestamps: true
});

// Indexes
notificationSchema.index({ user: 1, isRead: 1, createdAt: -1 });
notificationSchema.index({ user: 1, createdAt: -1 });

// Mark as read
notificationSchema.methods.markAsRead = async function() {
  this.isRead = true;
  this.readAt = new Date();
  await this.save();
  return this;
};

// Static method to create and send notification
notificationSchema.statics.createNotification = async function(userId, type, title, message, options = {}) {
  const notification = await this.create({
    user: userId,
    type,
    title,
    message,
    relatedEntity: options.relatedEntity || null,
    relatedEntityId: options.relatedEntityId || null,
    actionUrl: options.actionUrl || null,
    data: options.data || {}
  });
  
  return notification;
};

// Static method to get unread count
notificationSchema.statics.getUnreadCount = async function(userId) {
  return this.countDocuments({ user: userId, isRead: false });
};

// Static method to mark all as read
notificationSchema.statics.markAllAsRead = async function(userId) {
  return this.updateMany(
    { user: userId, isRead: false },
    { isRead: true, readAt: new Date() }
  );
};

module.exports = mongoose.model('Notification', notificationSchema);