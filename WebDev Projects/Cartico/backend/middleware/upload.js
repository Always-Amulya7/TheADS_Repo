/**
 * File Upload Middleware
 * Handles image uploads using Multer
 */

const multer = require('multer');
const path = require('path');
const { AppError } = require('../middleware/errorHandler');

// Configure storage
const storage = multer.diskStorage({
  destination: function (req, file, cb) {
    cb(null, 'uploads/');
  },
  filename: function (req, file, cb) {
    const uniqueSuffix = Date.now() + '-' + Math.round(Math.random() * 1E9);
    cb(null, file.fieldname + '-' + uniqueSuffix + path.extname(file.originalname));
  }
});

// File filter - only allow images
const fileFilter = (req, file, cb) => {
  const allowedTypes = /jpeg|jpg|png|gif|webp/;
  const extname = allowedTypes.test(path.extname(file.originalname).toLowerCase());
  const mimetype = allowedTypes.test(file.mimetype);

  if (extname && mimetype) {
    return cb(null, true);
  } else {
    cb(new AppError('Only image files are allowed!', 400), false);
  }
};

// Upload middleware for multiple images
const upload = multer({
  storage: storage,
  limits: {
    fileSize: 5 * 1024 * 1024 // 5MB max
  },
  fileFilter: fileFilter
});

// Upload single image
const uploadSingle = upload.single('image');

// Upload multiple images
const uploadMultiple = upload.array('images', 10);

// Upload product images (up to 5)
const uploadProductImages = upload.array('images', 5);

// Upload avatar
const uploadAvatar = upload.single('avatar');

// Upload attachment (for support tickets)
const uploadAttachment = upload.single('attachment');

// Error handler wrapper
const handleUpload = (uploadFn) => {
  return (req, res, next) => {
    uploadFn(req, res, function (err) {
      if (err instanceof multer.MulterError) {
        // A Multer error occurred when uploading
        if (err.code === 'LIMIT_FILE_SIZE') {
          return next(new AppError('File too large. Maximum size is 5MB.', 400));
        }
        return next(new AppError(err.message, 400));
      } else if (err) {
        // An unknown error occurred when uploading
        return next(err);
      }
      // Everything went fine
      next();
    });
  };
};

module.exports = {
  upload,
  uploadSingle,
  uploadMultiple,
  uploadProductImages,
  uploadAvatar,
  uploadAttachment,
  handleUpload
};