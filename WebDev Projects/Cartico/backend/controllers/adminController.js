/**
 * Admin Controller
 * Handles admin operations like user management, seller approval, analytics
 */

const User = require('../models/User');
const Product = require('../models/Product');
const Order = require('../models/Order');
const Category = require('../models/Category');
const Review = require('../models/Review');
const Coupon = require('../models/Coupon');
const { sendSellerApproval } = require('../services/emailService');
const { AppError } = require('../middleware/errorHandler');

/**
 * Get all users
 */
const getUsers = async (req, res, next) => {
  try {
    const { page = 1, limit = 20, role, search, isActive } = req.query;

    const query = {};

    if (role) query.role = role;
    if (isActive !== undefined) query.isActive = isActive === 'true';
    if (search) {
      query.$or = [
        { name: { $regex: search, $options: 'i' } },
        { email: { $regex: search, $options: 'i' } }
      ];
    }

    const pageNum = parseInt(page);
    const limitNum = parseInt(limit);
    const skip = (pageNum - 1) * limitNum;

    const users = await User.find(query)
      .select('-password -refreshToken')
      .sort({ createdAt: -1 })
      .skip(skip)
      .limit(limitNum);

    const count = await User.countDocuments(query);

    res.json({
      success: true,
      data: {
        users,
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
 * Get user by ID
 */
const getUser = async (req, res, next) => {
  try {
    const { id } = req.params;

    const user = await User.findById(id).select('-password -refreshToken');

    if (!user) {
      return next(new AppError('User not found', 404));
    }

    res.json({
      success: true,
      data: user
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Update user
 */
const updateUser = async (req, res, next) => {
  try {
    const { id } = req.params;
    const { name, email, role, isActive, phone, address } = req.body;

    const user = await User.findById(id);

    if (!user) {
      return next(new AppError('User not found', 404));
    }

    if (name) user.name = name;
    if (email) user.email = email;
    if (role && req.user.role === 'admin') user.role = role;
    if (isActive !== undefined) user.isActive = isActive;
    if (phone) user.phone = phone;
    if (address) user.address = address;

    await user.save();

    res.json({
      success: true,
      data: user
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Ban/Unban user
 */
const toggleUserBan = async (req, res, next) => {
  try {
    const { id } = req.params;
    const { ban, reason } = req.body;

    const user = await User.findById(id);

    if (!user) {
      return next(new AppError('User not found', 404));
    }

    // Can't ban admin
    if (user.role === 'admin') {
      return next(new AppError('Cannot ban admin users', 400));
    }

    user.isBanned = ban;
    user.banReason = ban ? reason : undefined;
    user.banReason = ban ? reason : undefined;
    user.bannedAt = ban ? new Date() : undefined;
    user.bannedBy = ban ? req.user._id : undefined;
    user.isActive = !ban;

    await user.save();

    res.json({
      success: true,
      message: ban ? 'User banned successfully' : 'User unbanned successfully',
      data: user
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get pending seller verifications
 */
const getPendingSellers = async (req, res, next) => {
  try {
    const sellers = await User.find({
      role: 'seller',
      verificationStatus: 'pending'
    }).select('-password -refreshToken');

    res.json({
      success: true,
      data: sellers
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Approve/Reject seller
 */
const verifySeller = async (req, res, next) => {
  try {
    const { id } = req.params;
    const { status, reason } = req.body;

    if (!['approved', 'rejected'].includes(status)) {
      return next(new AppError('Invalid status. Use "approved" or "rejected"', 400));
    }

    const user = await User.findById(id);

    if (!user) {
      return next(new AppError('User not found', 404));
    }

    if (user.role !== 'seller') {
      return next(new AppError('User is not a seller', 400));
    }

    user.verificationStatus = status;
    user.isVerified = status === 'approved';
    user.verifiedAt = status === 'approved' ? new Date() : undefined;
    user.verifiedBy = req.user._id;
    user.verificationReason = reason || '';

    await user.save();

    // Send email notification
    sendSellerApproval(user, status === 'approved').catch(console.error);

    res.json({
      success: true,
      message: status === 'approved' ? 'Seller approved successfully' : 'Seller rejected',
      data: user
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get dashboard stats
 */
const getDashboardStats = async (req, res, next) => {
  try {
    // User counts
    const userStats = await User.aggregate([
      { $group: { _id: '$role', count: { $sum: 1 } } }
    ]);

    const totalUsers = userStats.reduce((sum, u) => sum + u.count, 0);
    const customerCount = userStats.find(u => u._id === 'customer')?.count || 0;
    const sellerCount = userStats.find(u => u._id === 'seller')?.count || 0;
    const adminCount = userStats.find(u => u._id === 'admin')?.count || 0;

    // Product counts
    const productStats = await Product.aggregate([
      { $group: { _id: '$isActive', count: { $sum: 1 } } }
    ]);

    const totalProducts = productStats.reduce((sum, p) => sum + p.count, 0);
    const activeProducts = productStats.find(p => p._id === true)?.count || 0;

    // Order stats (last 30 days)
    const thirtyDaysAgo = new Date(Date.now() - 30 * 24 * 60 * 60 * 1000);
    const orderStats = await Order.aggregate([
      { $match: { createdAt: { $gte: thirtyDaysAgo } } },
      {
        $group: {
          _id: null,
          totalOrders: { $sum: 1 },
          totalRevenue: { $sum: '$totalPrice' },
          avgOrderValue: { $avg: '$totalPrice' }
        }
      }
    ]);

    // Pending orders
    const pendingOrders = await Order.countDocuments({ status: 'pending' });
    const pendingSellers = await User.countDocuments({ role: 'seller', verificationStatus: 'pending' });

    // Recent orders
    const recentOrders = await Order.find()
      .populate('user', 'name email')
      .sort({ createdAt: -1 })
      .limit(5);

    res.json({
      success: true,
      data: {
        users: {
          total: totalUsers,
          customers: customerCount,
          sellers: sellerCount,
          admins: adminCount
        },
        products: {
          total: totalProducts,
          active: activeProducts
        },
        orders: {
          last30Days: orderStats[0] || { totalOrders: 0, totalRevenue: 0, avgOrderValue: 0 },
          pending: pendingOrders
        },
        pendingSellers,
        recentOrders
      }
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get sales analytics
 */
const getSalesAnalytics = async (req, res, next) => {
  try {
    const { startDate, endDate, groupBy = 'day' } = req.query;

    const start = startDate ? new Date(startDate) : new Date(Date.now() - 30 * 24 * 60 * 60 * 1000);
    const end = endDate ? new Date(endDate) : new Date();

    let dateFormat;
    switch (groupBy) {
      case 'year':
        dateFormat = '%Y';
        break;
      case 'month':
        dateFormat = '%Y-%m';
        break;
      case 'day':
      default:
        dateFormat = '%Y-%m-%d';
    }

    const analytics = await Order.aggregate([
      {
        $match: {
          createdAt: { $gte: start, $lte: end },
          paymentStatus: 'paid'
        }
      },
      {
        $group: {
          _id: { $dateToString: { format: dateFormat, date: '$createdAt' } },
          totalOrders: { $sum: 1 },
          totalRevenue: { $sum: '$totalPrice' },
          totalItems: { $sum: { $size: '$orderItems' } }
        }
      },
      { $sort: { _id: 1 } }
    ]);

    // Top selling products
    const topProducts = await Order.aggregate([
      { $match: { createdAt: { $gte: start, $lte: end }, paymentStatus: 'paid' } },
      { $unwind: '$orderItems' },
      {
        $group: {
          _id: '$orderItems.product',
          name: { $first: '$orderItems.name' },
          totalSold: { $sum: '$orderItems.quantity' },
          totalRevenue: { $sum: { $multiply: ['$orderItems.price', '$orderItems.quantity'] } }
        }
      },
      { $sort: { totalSold: -1 } },
      { $limit: 10 }
    ]);

    // Top categories
    const topCategories = await Order.aggregate([
      { $match: { createdAt: { $gte: start, $lte: end }, paymentStatus: 'paid' } },
      { $unwind: '$orderItems' },
      {
        $lookup: {
          from: 'products',
          localField: 'orderItems.product',
          foreignField: '_id',
          as: 'product'
        }
      },
      { $unwind: '$product' },
      {
        $group: {
          _id: '$product.category',
          totalSold: { $sum: '$orderItems.quantity' },
          totalRevenue: { $sum: { $multiply: ['$orderItems.price', '$orderItems.quantity'] } }
        }
      },
      {
        $lookup: {
          from: 'categories',
          localField: '_id',
          foreignField: '_id',
          as: 'category'
        }
      },
      { $unwind: '$category' },
      { $sort: { totalRevenue: -1 } },
      { $limit: 5 }
    ]);

    res.json({
      success: true,
      data: {
        sales: analytics,
        topProducts,
        topCategories
      }
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Manage categories
 */
const manageCategories = async (req, res, next) => {
  try {
    const categories = await Category.find().sort({ displayOrder: 1, name: 1 });

    res.json({
      success: true,
      data: categories
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Manage coupons
 */
const manageCoupons = async (req, res, next) => {
  try {
    const { page = 1, limit = 20, active } = req.query;

    const query = {};
    if (active !== undefined) query.isActive = active === 'true';

    const pageNum = parseInt(page);
    const limitNum = parseInt(limit);
    const skip = (pageNum - 1) * limitNum;

    const coupons = await Coupon.find(query)
      .populate('createdBy', 'name')
      .sort({ createdAt: -1 })
      .skip(skip)
      .limit(limitNum);

    const count = await Coupon.countDocuments(query);

    res.json({
      success: true,
      data: {
        coupons,
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
 * Get reviews for moderation
 */
const getPendingReviews = async (req, res, next) => {
  try {
    const { page = 1, limit = 20 } = req.query;

    const pageNum = parseInt(page);
    const limitNum = parseInt(limit);
    const skip = (pageNum - 1) * limitNum;

    const reviews = await Review.find({ isApproved: false })
      .populate('user', 'name email')
      .populate('product', 'name')
      .sort({ createdAt: -1 })
      .skip(skip)
      .limit(limitNum);

    const count = await Review.countDocuments({ isApproved: false });

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
 * Moderate review
 */
const moderateReview = async (req, res, next) => {
  try {
    const { id } = req.params;
    const { approve, adminResponse } = req.body;

    const review = await Review.findById(id);

    if (!review) {
      return next(new AppError('Review not found', 404));
    }

    review.isApproved = approve;

    if (adminResponse) {
      review.adminResponse = adminResponse;
      review.adminResponseAt = new Date();
    }

    await review.save();

    // Update product rating if approved
    if (approve) {
      const product = await Product.findById(review.product);
      if (product) {
        await product.updateRating();
      }
    }

    res.json({
      success: true,
      message: approve ? 'Review approved' : 'Review rejected',
      data: review
    });
  } catch (error) {
    next(error);
  }
};

module.exports = {
  getUsers,
  getUser,
  updateUser,
  toggleUserBan,
  getPendingSellers,
  verifySeller,
  getDashboardStats,
  getSalesAnalytics,
  manageCategories,
  manageCoupons,
  getPendingReviews,
  moderateReview
};