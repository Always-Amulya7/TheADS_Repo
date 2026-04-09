/**
 * Product Controller
 * Handles product CRUD operations and search
 */

const Product = require('../models/Product');
const Category = require('../models/Category');
const User = require('../models/User');
const { AppError } = require('../middleware/errorHandler');

/**
 * Get all products (public)
 */
const getProducts = async (req, res, next) => {
  try {
    const {
      category,
      subcategory,
      search,
      minPrice,
      maxPrice,
      brand,
      color,
      size,
      sort = '-createdAt',
      page = 1,
      limit = 12,
      featured,
      flashSale
    } = req.query;

    // Build query
    const query = { isActive: true };

    // Category filter
    if (category) {
      const cat = await Category.findOne({ slug: category });
      if (cat) {
        query.category = cat._id;
        if (subcategory) {
          const subcat = await Category.findOne({ slug: subcategory, parentCategory: cat._id });
          if (subcat) query.subCategory = subcat._id;
        }
      }
    }

    // Search filter
    if (search) {
      query.$or = [
        { name: { $regex: search, $options: 'i' } },
        { description: { $regex: search, $options: 'i' } },
        { tags: { $in: [new RegExp(search, 'i')] } }
      ];
    }

    // Price filter
    if (minPrice || maxPrice) {
      query.price = {};
      if (minPrice) query.price.$gte = Number(minPrice);
      if (maxPrice) query.price.$lte = Number(maxPrice);
    }

    // Brand filter
    if (brand) {
      query.brand = { $regex: brand, $options: 'i' };
    }

    // Featured filter
    if (featured === 'true') {
      query.isFeatured = true;
    }

    // Flash sale filter
    if (flashSale === 'true') {
      query.isFlashSale = true;
      query.flashSaleEndDate = { $gt: new Date() };
    }

    // Sorting options
    let sortOption = {};
    switch (sort) {
      case 'price-asc':
        sortOption = { price: 1 };
        break;
      case 'price-desc':
        sortOption = { price: -1 };
        break;
      case 'name-asc':
        sortOption = { name: 1 };
        break;
      case 'name-desc':
        sortOption = { name: -1 };
        break;
      case 'rating':
        sortOption = { ratings: -1 };
        break;
      case 'newest':
        sortOption = { createdAt: -1 };
        break;
      default:
        sortOption = { createdAt: -1 };
    }

    // Pagination
    const pageNum = parseInt(page);
    const limitNum = parseInt(limit);
    const skip = (pageNum - 1) * limitNum;

    // Execute query
    const products = await Product.find(query)
      .populate('seller', 'name businessName')
      .populate('category', 'name slug')
      .sort(sortOption)
      .skip(skip)
      .limit(limitNum);

    const count = await Product.countDocuments(query);

    res.json({
      success: true,
      data: {
        products,
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
 * Get featured products
 */
const getFeaturedProducts = async (req, res, next) => {
  try {
    const products = await Product.find({ isActive: true, isFeatured: true })
      .populate('seller', 'name businessName')
      .populate('category', 'name slug')
      .limit(12)
      .sort({ ratings: -1 });

    res.json({
      success: true,
      data: products
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get flash sale products
 */
const getFlashSaleProducts = async (req, res, next) => {
  try {
    const products = await Product.find({
      isActive: true,
      isFlashSale: true,
      flashSaleEndDate: { $gt: new Date() }
    })
      .populate('seller', 'name businessName')
      .populate('category', 'name slug')
      .sort({ flashSaleEndDate: 1 });

    res.json({
      success: true,
      data: products
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get single product
 */
const getProduct = async (req, res, next) => {
  try {
    const { id } = req.params;
    
    const product = await Product.findById(id)
      .populate('seller', 'name email phone businessName businessDescription')
      .populate('category', 'name slug');

    if (!product) {
      return next(new AppError('Product not found', 404));
    }

    // Increment view count
    product.views += 1;
    await product.save();

    res.json({
      success: true,
      data: product
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get product by slug
 */
const getProductBySlug = async (req, res, next) => {
  try {
    const { slug } = req.params;
    
    const product = await Product.findOne({ slug, isActive: true })
      .populate('seller', 'name email phone businessName businessDescription')
      .populate('category', 'name slug');

    if (!product) {
      return next(new AppError('Product not found', 404));
    }

    res.json({
      success: true,
      data: product
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Create product (seller only)
 */
const createProduct = async (req, res, next) => {
  try {
    // Check if seller is verified
    if (!req.user.isVerified && req.user.role !== 'admin') {
      return next(new AppError('Your seller account must be verified to add products', 403));
    }

    const productData = {
      ...req.body,
      seller: req.user._id
    };

    const product = await Product.create(productData);

    res.status(201).json({
      success: true,
      data: product
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Update product (seller/admin only)
 */
const updateProduct = async (req, res, next) => {
  try {
    const { id } = req.params;

    const product = await Product.findById(id);

    if (!product) {
      return next(new AppError('Product not found', 404));
    }

    // Check ownership or admin
    if (product.seller.toString() !== req.user._id.toString() && req.user.role !== 'admin') {
      return next(new AppError('Not authorized to update this product', 403));
    }

    const updatedProduct = await Product.findByIdAndUpdate(
      id,
      req.body,
      { new: true, runValidators: true }
    );

    res.json({
      success: true,
      data: updatedProduct
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Delete product (seller/admin only)
 */
const deleteProduct = async (req, res, next) => {
  try {
    const { id } = req.params;

    const product = await Product.findById(id);

    if (!product) {
      return next(new AppError('Product not found', 404));
    }

    // Check ownership or admin
    if (product.seller.toString() !== req.user._id.toString() && req.user.role !== 'admin') {
      return next(new AppError('Not authorized to delete this product', 403));
    }

    // Soft delete - set isActive to false
    product.isActive = false;
    await product.save();

    res.json({
      success: true,
      message: 'Product deleted successfully'
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get seller's products
 */
const getSellerProducts = async (req, res, next) => {
  try {
    const { page = 1, limit = 20, status, search } = req.query;

    const query = { seller: req.user._id };

    if (status) {
      query.isActive = status === 'active';
    }

    if (search) {
      query.name = { $regex: search, $options: 'i' };
    }

    const pageNum = parseInt(page);
    const limitNum = parseInt(limit);
    const skip = (pageNum - 1) * limitNum;

    const products = await Product.find(query)
      .populate('category', 'name')
      .sort({ createdAt: -1 })
      .skip(skip)
      .limit(limitNum);

    const count = await Product.countDocuments(query);

    res.json({
      success: true,
      data: {
        products,
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
 * Update product stock
 */
const updateStock = async (req, res, next) => {
  try {
    const { id } = req.params;
    const { stock } = req.body;

    const product = await Product.findById(id);

    if (!product) {
      return next(new AppError('Product not found', 404));
    }

    // Check ownership
    if (product.seller.toString() !== req.user._id.toString() && req.user.role !== 'admin') {
      return next(new AppError('Not authorized to update this product', 403));
    }

    product.stock = stock;
    await product.save();

    res.json({
      success: true,
      data: product
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get related products
 */
const getRelatedProducts = async (req, res, next) => {
  try {
    const { id } = req.params;
    const { limit = 4 } = req.query;

    const product = await Product.findById(id);

    if (!product) {
      return next(new AppError('Product not found', 404));
    }

    const relatedProducts = await Product.find({
      _id: { $ne: product._id },
      category: product.category,
      isActive: true
    })
      .populate('seller', 'name')
      .limit(parseInt(limit))
      .sort({ ratings: -1 });

    res.json({
      success: true,
      data: relatedProducts
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get seller analytics
 */
const getSellerAnalytics = async (req, res, next) => {
  try {
    const products = await Product.find({ seller: req.user._id });
    
    const totalProducts = products.length;
    const activeProducts = products.filter(p => p.isActive).length;
    const totalStock = products.reduce((sum, p) => sum + p.stock, 0);
    const lowStockProducts = products.filter(p => p.stock > 0 && p.stock <= p.lowStockThreshold).length;
    const outOfStockProducts = products.filter(p => p.stock === 0).length;
    const totalViews = products.reduce((sum, p) => sum + p.views, 0);

    res.json({
      success: true,
      data: {
        totalProducts,
        activeProducts,
        inactiveProducts: totalProducts - activeProducts,
        totalStock,
        lowStockProducts,
        outOfStockProducts,
        totalViews,
        averageRating: products.reduce((sum, p) => sum + p.ratings, 0) / (totalProducts || 1)
      }
    });
  } catch (error) {
    next(error);
  }
};

module.exports = {
  getProducts,
  getFeaturedProducts,
  getFlashSaleProducts,
  getProduct,
  getProductBySlug,
  createProduct,
  updateProduct,
  deleteProduct,
  getSellerProducts,
  updateStock,
  getRelatedProducts,
  getSellerAnalytics
};