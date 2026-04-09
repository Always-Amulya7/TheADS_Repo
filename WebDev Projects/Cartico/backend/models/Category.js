/**
 * Category Model
 * Handles product categories and subcategories
 */

const mongoose = require('mongoose');

const categorySchema = new mongoose.Schema({
  name: {
    type: String,
    required: [true, 'Please provide a category name'],
    trim: true,
    unique: true,
    maxlength: [100, 'Category name cannot be more than 100 characters']
  },
  slug: {
    type: String,
    unique: true,
    lowercase: true
  },
  description: {
    type: String,
    maxlength: 500
  },
  image: {
    url: String,
    publicId: String
  },
  parentCategory: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Category',
    default: null
  },
  // For subcategories
  isSubcategory: {
    type: Boolean,
    default: false
  },
  // Category status
  isActive: {
    type: Boolean,
    default: true
  },
  // Display order
  displayOrder: {
    type: Number,
    default: 0
  },
  // For mega menu
  showInMenu: {
    type: Boolean,
    default: false
  },
  // SEO
  metaTitle: String,
  metaDescription: String
}, {
  timestamps: true,
  toJSON: { virtuals: true },
  toObject: { virtuals: true }
});

// Index for parentCategory lookup only (slug has unique: true which auto-creates index)
categorySchema.index({ parentCategory: 1 });
categorySchema.index({ isActive: 1 });

// Virtual for subcategories
categorySchema.virtual('subcategories', {
  ref: 'Category',
  localField: '_id',
  foreignField: 'parentCategory'
});

// Pre-save to generate slug
categorySchema.pre('save', function(next) {
  if (!this.slug) {
    this.slug = this.name
      .toLowerCase()
      .replace(/[^a-z0-9]+/g, '-')
      .replace(/(^-|-$)/g, '');
  }
  
  // Set isSubcategory flag
  if (this.parentCategory) {
    this.isSubcategory = true;
  }
  
  next();
});

// Static method to get category tree
categorySchema.statics.getCategoryTree = async function() {
  const categories = await this.find({ isActive: true }).sort('displayOrder');
  
  const buildTree = (parentId = null) => {
    return categories
      .filter(cat => {
        if (parentId === null) return !cat.parentCategory;
        return cat.parentCategory && cat.parentCategory.toString() === parentId.toString();
      })
      .map(cat => ({
        _id: cat._id,
        name: cat.name,
        slug: cat.slug,
        image: cat.image,
        subcategories: buildTree(cat._id)
      }));
  };
  
  return buildTree();
};

module.exports = mongoose.model('Category', categorySchema);