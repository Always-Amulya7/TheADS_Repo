# Cartico - E-Commerce Platform

A full-featured shopping application built with Node.js, Express, MongoDB, and vanilla JavaScript.

## Features

- **Multi-role Authentication**: Customer, Seller, and Admin accounts
- **Shopping Cart**: Full cart functionality with quantity management
- **Product Management**: Sellers can add, edit, and delete products
- **Order System**: Complete order placement and tracking
- **Payment Options**: Credit/Debit Card, PayPal, Cash on Delivery
- **Seller Dashboard**: Manage products and view orders
- **Admin Dashboard**: Manage users, products, and view all orders

## Tech Stack

- **Backend**: Node.js, Express
- **Database**: MongoDB with Mongoose
- **Authentication**: JWT (JSON Web Tokens)
- **Frontend**: HTML, CSS, Vanilla JavaScript

## Getting Started

### Prerequisites

- Node.js (v14+)
- MongoDB (local or Atlas)
- npm or yarn

### Installation

1. Install dependencies:
```bash
npm install
```

2. Start MongoDB (if running locally):
```bash
mongod
```

3. Seed the database with sample data:
```bash
node seed.js
```

4. Start the server:
```bash
npm start
```

5. Open http://localhost:3000 in your browser

## Login Credentials

| Role | Email | Password |
|------|-------|----------|
| Admin | admin@cartico.com | admin123 |
| Seller | seller@cartico.com | seller123 |
| Customer | customer@cartico.com | customer123 |

## Project Structure

```
cartico/
├── models/              # Mongoose models
│   ├── User.js
│   ├── Product.js
│   ├── Order.js
│   └── Cart.js
├── routes/              # API routes
│   ├── auth.js
│   ├── products.js
│   ├── orders.js
│   └── users.js
├── middleware/          # Custom middleware
│   └── auth.js
├── assets/
│   ├── css/
│   ├── js/
│   └── images/
├── index.html           # Main storefront
├── server.js            # Express server
├── package.json
└── seed.js             # Database seeder
```

## API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - Login user
- `GET /api/auth/profile` - Get user profile
- `PUT /api/auth/profile` - Update user profile

### Products
- `GET /api/products` - Get all products
- `GET /api/products/featured` - Get featured products
- `GET /api/products/:id` - Get product by ID
- `POST /api/products` - Create product (seller)
- `PUT /api/products/:id` - Update product (seller)
- `DELETE /api/products/:id` - Delete product (seller)
- `GET /api/products/seller/my-products` - Seller's products

### Orders
- `POST /api/orders` - Create order
- `GET /api/orders/my-orders` - Get user's orders
- `GET /api/orders/:id` - Get order by ID
- `PUT /api/orders/:id/status` - Update order status (seller)
- `PUT /api/orders/:id/pay` - Update payment status
- `GET /api/orders/seller/all` - Get all orders (seller)

### Cart
- `GET /api/users/cart` - Get user's cart
- `POST /api/users/cart/add` - Add item to cart
- `PUT /api/users/cart/update` - Update cart item
- `DELETE /api/users/cart/remove/:productId` - Remove from cart
- `DELETE /api/users/cart/clear` - Clear cart

## Pages

- `/` - Main storefront with products
- `/cart.html` - Shopping cart
- `/checkout.html` - Checkout page
- `/seller-dashboard.html` - Seller dashboard
- `/admin-dashboard.html` - Admin dashboard

## License

MIT
