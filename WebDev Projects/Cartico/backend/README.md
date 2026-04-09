# Cartico Backend - E-commerce Platform

A production-ready backend system for the Cartico e-commerce platform built with Node.js, Express, and MongoDB.

## 🏗️ Architecture

The backend follows a modular MVC (Model-View-Controller) architecture with Clean Architecture principles:

```
backend/
├── config/           # Configuration files
│   └── database.js   # MongoDB connection
├── controllers/      # Business logic
│   ├── adminController.js
│   ├── authController.js
│   ├── cartController.js
│   ├── categoryController.js
│   ├── orderController.js
│   └── productController.js
├── middleware/       # Express middleware
│   ├── auth.js       # JWT authentication
│   ├── errorHandler.js
│   ├── upload.js     # File uploads
│   └── validate.js   # Input validation
├── models/           # Mongoose schemas
│   ├── Cart.js
│   ├── Category.js
│   ├── Coupon.js
│   ├── Notification.js
│   ├── Order.js
│   ├── Product.js
│   ├── RecentlyViewed.js
│   ├── Review.js
│   ├── SupportTicket.js
│   ├── User.js
│   └── Wishlist.js
├── routes/           # API routes
│   ├── admin.js
│   ├── auth.js
│   ├── cart.js
│   ├── categories.js
│   ├── orders.js
│   └── products.js
├── services/         # External services
│   ├── emailService.js
│   ├── razorpayService.js
│   └── stripeService.js
├── utils/            # Utilities
│   └── AppError.js
├── .env.example      # Environment variables
├── package.json
└── server.js         # Entry point
```

## 🚀 Quick Start

### Prerequisites
- Node.js 18+
- MongoDB 6+
- npm or yarn

### Installation

1. **Navigate to backend directory:**
   ```bash
   cd backend
   ```

2. **Install dependencies:**
   ```bash
   npm install
   ```

3. **Create environment file:**
   ```bash
   cp .env.example .env
   ```

4. **Update `.env` with your values:**
   - MongoDB connection string
   - JWT secrets
   - Payment gateway keys (Stripe/Razorpay)
   - Email credentials

5. **Start MongoDB** (if running locally):
   ```bash
   mongod
   ```

6. **Start the server:**
   ```bash
   # Development
   npm run dev
   
   # Production
   npm start
   ```

7. **Seed database (optional):**
   ```bash
   npm run seed
   ```

## 🔐 API Endpoints

### Authentication
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register new user |
| POST | `/api/auth/login` | User login |
| POST | `/api/auth/refresh-token` | Refresh access token |
| POST | `/api/auth/forgot-password` | Request password reset |
| POST | `/api/auth/reset-password` | Reset password |
| GET | `/api/auth/profile` | Get current user |
| PUT | `/api/auth/profile` | Update profile |

### Products
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/featured` | Get featured products |
| GET | `/api/products/flash-sale` | Get flash sale products |
| GET | `/api/products/:id` | Get product by ID |
| POST | `/api/products` | Create product (seller) |
| PUT | `/api/products/:id` | Update product |
| DELETE | `/api/products/:id` | Delete product |

### Categories
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/categories` | Get all categories |
| GET | `/api/categories/tree` | Get category tree |
| GET | `/api/categories/:slug/products` | Get products by category |

### Orders
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/orders` | Create order |
| GET | `/api/orders/my-orders` | Get my orders |
| GET | `/api/orders/:id` | Get order by ID |
| PUT | `/api/orders/:id/cancel` | Cancel order |
| PUT | `/api/orders/:id/status` | Update order status (seller) |

### Cart
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/cart` | Get cart |
| POST | `/api/cart/add` | Add item to cart |
| PUT | `/api/cart/item` | Update cart item |
| DELETE | `/api/cart/item/:id` | Remove item |
| POST | `/api/cart/coupon/apply` | Apply coupon |

### Admin
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/admin/dashboard/stats` | Dashboard statistics |
| GET | `/api/admin/users` | Get all users |
| PUT | `/api/admin/users/:id/ban` | Ban/unban user |
| GET | `/api/admin/sellers/pending` | Get pending sellers |
| PUT | `/api/admin/sellers/:id/verify` | Approve/reject seller |

## 👥 User Roles

- **Customer**: Browse products, add to cart, place orders
- **Seller**: Manage products, view orders, view analytics
- **Admin**: Manage users, sellers, categories, view platform analytics

## 💳 Payment Integration

### Stripe (International)
- Card payments
- Secure checkout with Stripe Elements

### Razorpay (India)
- Card payments
- UPI payments
- Wallet payments

## 📧 Email Notifications

- Welcome email
- Order confirmation
- Order shipped
- Order delivered
- Password reset
- Seller approval

## 🔒 Security Features

- JWT authentication with refresh tokens
- Role-based access control (RBAC)
- Input validation with Joi
- Rate limiting
- Helmet for security headers
- Password hashing with bcrypt
- SQL injection prevention
- XSS protection

## 🧪 Testing with Postman

Import the Postman collection from `postman/Cartico API.postman_collection.json` to test all endpoints.

## 📦 Key Features

- [x] User authentication (JWT + Refresh tokens)
- [x] Role-based access control
- [x] Product management with variants
- [x] Category management
- [x] Shopping cart
- [x] Order management
- [x] Payment integration (Stripe + Razorpay)
- [x] Coupon system
- [x] Wishlist
- [x] Recently viewed products
- [x] Reviews and ratings
- [x] Customer support tickets
- [x] Email notifications
- [x] Admin dashboard
- [x] Seller dashboard

## 🔧 Configuration

### Environment Variables

| Variable | Description | Required |
|----------|-------------|----------|
| PORT | Server port | Yes |
| MONGODB_URI | MongoDB connection string | Yes |
| JWT_SECRET | JWT access token secret | Yes |
| JWT_REFRESH_SECRET | JWT refresh token secret | Yes |
| STRIPE_SECRET_KEY | Stripe secret key | No |
| RAZORPAY_KEY_ID | Razorpay key ID | No |
| SMTP_HOST | Email SMTP host | No |
| SMTP_USER | Email username | No |
| SMTP_PASS | Email password | No |

## 🚀 Deployment

### Using PM2
```bash
pm2 start server.js --name cartico
```

### Using Docker
```bash
docker build -t cartico-backend .
docker run -p 3001:3001 cartico-backend
```

## 📄 License

MIT License - feel free to use this for your own projects!