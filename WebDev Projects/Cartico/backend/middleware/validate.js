/**
 * Input Validation Middleware
 * Uses Joi for schema validation
 */

const Joi = require('joi');
const { AppError } = require('../middleware/errorHandler');

/**
 * Validation Schemas
 */

// User Registration Schema
const registerSchema = Joi.object({
  name: Joi.string().min(2).max(50).required(),
  email: Joi.string().email().required(),
  password: Joi.string().min(6).max(30).required(),
  role: Joi.string().valid('customer', 'seller').default('customer'),
  phone: Joi.string().pattern(/^[0-9+\-\s]{10,15}$/),
  businessName: Joi.string().max(100).when('role', {
    is: 'seller',
    then: Joi.required()
  }),
  businessDescription: Joi.string().max(500)
});

// User Login Schema
const loginSchema = Joi.object({
  email: Joi.string().email().required(),
  password: Joi.string().required()
});

// Update Profile Schema
const updateProfileSchema = Joi.object({
  name: Joi.string().min(2).max(50),
  phone: Joi.string().pattern(/^[0-9+\-\s]{10,15}$/),
  address: Joi.object({
    street: Joi.string(),
    city: Joi.string(),
    state: Joi.string(),
    zipCode: Joi.string(),
    country: Joi.string()
  }),
  businessName: Joi.string().max(100),
  businessDescription: Joi.string().max(500),
  avatar: Joi.string().uri()
});

// Product Schema
const productSchema = Joi.object({
  name: Joi.string().min(3).max(200).required(),
  description: Joi.string().min(10).required(),
  shortDescription: Joi.string().max(500),
  price: Joi.number().min(0).required(),
  originalPrice: Joi.number().min(0),
  category: Joi.string().required(),
  subCategory: Joi.string(),
  images: Joi.array().items(Joi.string().uri()),
  stock: Joi.number().integer().min(0).default(0),
  lowStockThreshold: Joi.number().integer().min(0).default(10),
  brand: Joi.string().max(50),
  colors: Joi.array().items(Joi.object({
    name: Joi.string(),
    hex: Joi.string(),
    available: Joi.boolean()
  })),
  sizes: Joi.array().items(Joi.object({
    name: Joi.string(),
    available: Joi.boolean()
  })),
  features: Joi.array().items(Joi.string()),
  weight: Joi.number().min(0),
  dimensions: Joi.object({
    length: Joi.number().min(0),
    width: Joi.number().min(0),
    height: Joi.number().min(0)
  }),
  isFeatured: Joi.boolean(),
  isFlashSale: Joi.boolean(),
  flashSalePrice: Joi.number().min(0),
  flashSaleStartDate: Joi.date(),
  flashSaleEndDate: Joi.date(),
  discount: Joi.number().min(0).max(100),
  metaTitle: Joi.string().max(200),
  metaDescription: Joi.string().max(500),
  metaKeywords: Joi.array().items(Joi.string()),
  tags: Joi.array().items(Joi.string())
});

// Category Schema
const categorySchema = Joi.object({
  name: Joi.string().min(2).max(100).required(),
  description: Joi.string().max(500),
  image: Joi.object({
    url: Joi.string().uri(),
    publicId: Joi.string()
  }),
  parentCategory: Joi.string(),
  displayOrder: Joi.number().integer().min(0),
  showInMenu: Joi.boolean(),
  metaTitle: Joi.string().max(200),
  metaDescription: Joi.string().max(500)
});

// Order Schema
const orderSchema = Joi.object({
  shippingAddress: Joi.object({
    fullName: Joi.string().min(2).max(100).required(),
    phone: Joi.string().pattern(/^[0-9+\-\s]{10,15}$/).required(),
    address: Joi.object({
      street: Joi.string(),
      city: Joi.string(),
      state: Joi.string(),
      zipCode: Joi.string(),
      country: Joi.string()
    }).required()
  }).required(),
  paymentMethod: Joi.string().valid('card', 'cod', 'paypal', 'stripe', 'razorpay', 'upi', 'wallet').required()
});

// Cart Item Schema
const cartItemSchema = Joi.object({
  productId: Joi.string().required(),
  name: Joi.string().required(),
  price: Joi.number().min(0).required(),
  quantity: Joi.number().integer().min(1).default(1),
  image: Joi.string().uri(),
  color: Joi.string(),
  size: Joi.string()
});

// Review Schema
const reviewSchema = Joi.object({
  product: Joi.string().required(),
  rating: Joi.number().integer().min(1).max(5).required(),
  title: Joi.string().max(200),
  comment: Joi.string().min(10).max(2000).required(),
  images: Joi.array().items(Joi.string().uri()),
  pros: Joi.array().items(Joi.string()),
  cons: Joi.array().items(Joi.string())
});

// Support Ticket Schema
const ticketSchema = Joi.object({
  category: Joi.string().valid('general', 'order', 'product', 'payment', 'refund', 'return', 'account', 'other').default('general'),
  subject: Joi.string().min(5).max(200).required(),
  description: Joi.string().min(20).required(),
  priority: Joi.string().valid('low', 'medium', 'high', 'urgent').default('medium'),
  order: Joi.string(),
  product: Joi.string()
});

// Coupon Schema
const couponSchema = Joi.object({
  code: Joi.string().uppercase().min(3).max(20).required(),
  description: Joi.string().max(500),
  discountType: Joi.string().valid('percentage', 'fixed').required(),
  discountValue: Joi.number().min(0).required(),
  maxDiscount: Joi.number().min(0),
  minOrderValue: Joi.number().min(0).default(0),
  usageLimit: Joi.number().integer().min(1),
  perUserLimit: Joi.number().integer().min(1).default(1),
  startDate: Joi.date().required(),
  endDate: Joi.date().required(),
  applicableCategories: Joi.array().items(Joi.string()),
  applicableProducts: Joi.array().items(Joi.string()),
  newUsersOnly: Joi.boolean(),
  usageType: Joi.string().valid('general', 'first_order', 'specific_user', 'category')
});

/**
 * Middleware Factory - Validate Request
 */
const validate = (schema, property = 'body') => {
  return (req, res, next) => {
    const { error } = schema.validate(req[property], {
      abortEarly: false,
      stripUnknown: true
    });

    if (error) {
      const errorMessage = error.details.map(detail => detail.message).join(', ');
      return next(new AppError(errorMessage, 400));
    }

    next();
  };
};

/**
 * Validation Middlewares
 */
const validateRegister = validate(registerSchema);
const validateLogin = validate(loginSchema);
const validateUpdateProfile = validate(updateProfileSchema);
const validateProduct = validate(productSchema);
const validateCategory = validate(categorySchema);
const validateOrder = validate(orderSchema);
const validateCartItem = validate(cartItemSchema);
const validateReview = validate(reviewSchema);
const validateTicket = validate(ticketSchema);
const validateCoupon = validate(couponSchema);

module.exports = {
  validate,
  validateRegister,
  validateLogin,
  validateUpdateProfile,
  validateProduct,
  validateCategory,
  validateOrder,
  validateCartItem,
  validateReview,
  validateTicket,
  validateCoupon,
  schemas: {
    registerSchema,
    loginSchema,
    productSchema,
    categorySchema,
    orderSchema,
    reviewSchema,
    ticketSchema,
    couponSchema
  }
};