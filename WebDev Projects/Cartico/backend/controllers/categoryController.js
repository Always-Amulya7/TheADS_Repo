/**
 * Category Controller
 * Handles category CRUD operations
 */

const Category = require('../models/Category');
const Product = require('../models/Product');
const { AppError } = require('../middleware/errorHandler');

/**
 * Get all categories (public)
 */
const getCategories = async (req, res, next) => {
  try {
    const { active, menu } = req.query;
    
    const query = {};
    
    if (active === 'true') {
      query.isActive = true;
    }
    
    if (menu === 'true') {
      query.showInMenu = true;
    }

    const categories = await Category.find(query)
      .populate('parentCategory', 'name slug')
      .sort({ displayOrder: 1, name: 1 });

    res.json({
      success: true,
      data: categories
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get category tree (hierarchical)
 */
const getCategoryTree = async (req, res, next) => {
  try {
    const categories = await Category.getCategoryTree();

    res.json({
      success: true,
      data: categories
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get single category
 */
const getCategory = async (req, res, next) => {
  try {
    const { id } = req.params;
    
    const category = await Category.findById(id)
      .populate('parentCategory', 'name slug');

    if (!category) {
      return next(new AppError('Category not found', 404));
    }

    res.json({
      success: true,
      data: category
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get category by slug
 */
const getCategoryBySlug = async (req, res, next) => {
  try {
    const { slug } = req.params;
    
    const category = await Category.findOne({ slug })
      .populate('parentCategory', 'name slug');

    if (!category) {
      return next(new AppError('Category not found', 404));
    }

    res.json({
      success: true,
      data: category
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get category with products
 */
const getCategoryWithProducts = async (req, res, next) => {
  try {
    const { slug } = req.params;
    const { page = 1, limit = 12, sort = '-createdAt' } = req.query;

    const category = await Category.findOne({ slug });

    if (!category) {
      return next(new AppError('Category not found', 404));
    }

    // Build product query
    const productQuery = {
      isActive: true,
      $or: [
        { category: category._id },
        { subCategory: category._id }
      ]
    };

    // Sorting
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
      case 'rating':
        sortOption = { ratings: -1 };
        break;
      default:
        sortOption = { createdAt: -1 };
    }

    const pageNum = parseInt(page);
    const limitNum = parseInt(limit);
    const skip = (pageNum - 1) * limitNum;

    const products = await Product.find(productQuery)
      .populate('seller', 'name')
      .sort(sortOption)
      .skip(skip)
      .limit(limitNum);

    const count = await Product.countDocuments(productQuery);

    res.json({
      success: true,
      data: {
        category,
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
 * Create category (admin only)
 */
const createCategory = async (req, res, next) => {
  try {
    const { name, description, image, parentCategory, displayOrder, showInMenu, metaTitle, metaDescription } = req.body;

    // Check for duplicate
    const existing = await Category.findOne({ name: { $regex: new RegExp(`^${name}$`, 'i') } });
    if (existing) {
      return next(new AppError('Category already exists', 400));
    }

    const category = await Category.create({
      name,
      description,
      image,
      parentCategory,
      displayOrder,
      showInMenu,
      metaTitle,
      metaDescription
    });

    res.status(201).json({
      success: true,
      data: category
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Update category (admin only)
 */
const updateCategory = async (req, res, next) => {
  try {
    const { id } = req.params;

    const category = await Category.findByIdAndUpdate(
      id,
      req.body,
      { new: true, runValidators: true }
    );

    if (!category) {
      return next(new AppError('Category not found', 404));
    }

    res.json({
      success: true,
      data: category
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Delete category (admin only)
 */
const deleteCategory = async (req, res, next) => {
  try {
    const { id } = req.params;

    // Check if category has products
    const productCount = await Product.countDocuments({
      $or: [{ category: id }, { subCategory: id }]
    });

    if (productCount > 0) {
      return next(new AppError('Cannot delete category with products. Remove products first.', 400));
    }

    // Check for subcategories
    const subcategoryCount = await Category.countDocuments({ parentCategory: id });

    if (subcategoryCount > 0) {
      return next(new AppError('Cannot delete category with subcategories. Remove subcategories first.', 400));
    }

    const category = await Category.findByIdAndDelete(id);

    if (!category) {
      return next(new AppError('Category not found', 404));
    }

    res.json({
      success: true,
      message: 'Category deleted successfully'
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get subcategories
 */
const getSubcategories = async (req, res, next) => {
  try {
    const { parentId } = req.params;

    const subcategories = await Category.find({
      parentCategory: parentId,
      isActive: true
    }).sort({ displayOrder: 1, name: 1 });

    res.json({
      success: true,
      data: subcategories
    });
  } catch (error) {
    next(error);
  }
};

/**
 * Get popular categories
 */
const getPopularCategories = async (req, res, next) => {
  try {
    // Get categories sorted by product count
    const categories = await Category.aggregate([
      { $match: { isActive: true } },
      {
        $lookup: {
          from: 'products',
          localField: '_id',
          foreignField: 'category',
          as: 'products'
        }
      },
      {
        $addFields: {
          productCount: { $size: '$products' }
        }
      },
      { $sort: { productCount: -1 } },
      { $limit: 10 }
    ]);

    res.json({
      success: true,
      data: categories
    });
  } catch (error) {
    next(error);
  }
};

module.exports = {
  getCategories,
  getCategoryTree,
  getCategory,
  getCategoryBySlug,
  getCategoryWithProducts,
  createCategory,
  updateCategory,
  deleteCategory,
  getSubcategories,
  getPopularCategories
};