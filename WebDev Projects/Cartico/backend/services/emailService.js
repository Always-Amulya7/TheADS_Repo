/**
 * Email Service
 * Handles sending emails using Nodemailer
 */

const nodemailer = require('nodemailer');
const mg = require('nodemailer-mailgun-transport'); // Optional: for Mailgun
const { AppError } = require('../middleware/errorHandler');

// Create transporter
const createTransporter = async () => {
  // Check if using Mailgun
  if (process.env.MAILGUN_API_KEY) {
    return nodemailer.createTransport(mg({
      auth: {
        api_key: process.env.MAILGUN_API_KEY,
        domain: process.env.MAILGUN_DOMAIN
      }
    }));
  }

  // Default: Use SMTP
  return nodemailer.createTransport({
    host: process.env.SMTP_HOST || 'smtp.gmail.com',
    port: process.env.SMTP_PORT || 587,
    secure: false, // true for 465, false for other ports
    auth: {
      user: process.env.SMTP_USER,
      pass: process.env.SMTP_PASS
    }
  });
};

/**
 * Send Email
 */
const sendEmail = async (options) => {
  try {
    const transporter = await createTransporter();

    const mailOptions = {
      from: process.env.EMAIL_FROM || '"Cartico" <noreply@cartico.com>',
      to: options.to,
      subject: options.subject,
      html: options.html,
      text: options.text
    };

    const info = await transporter.sendMail(mailOptions);
    console.log(`Email sent: ${info.messageId}`);
    return info;
  } catch (error) {
    console.error('Email send error:', error);
    throw new AppError('Email could not be sent', 500);
  }
};

/**
 * Send Welcome Email
 */
const sendWelcomeEmail = async (user) => {
  const subject = 'Welcome to Cartico!';
  const html = `
    <h1>Welcome, ${user.name}!</h1>
    <p>Thank you for joining Cartico. We're excited to have you on board!</p>
    <p>Start shopping and discover amazing products at great prices.</p>
    <a href="${process.env.FRONTEND_URL || 'http://localhost:3000'}" style="padding: 10px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 5px;">Start Shopping</a>
  `;

  await sendEmail({ to: user.email, subject, html });
};

/**
 * Send Order Confirmation Email
 */
const sendOrderConfirmation = async (order, user) => {
  const subject = `Order Confirmation - ${order.orderNumber}`;
  
  const itemsHtml = order.orderItems.map(item => `
    <tr>
      <td>${item.name}</td>
      <td>${item.quantity}</td>
      <td>$${item.price.toFixed(2)}</td>
    </tr>
  `).join('');

  const html = `
    <h1>Order Confirmed!</h1>
    <p>Thank you for your order, ${user.name}!</p>
    <h2>Order Details</h2>
    <p><strong>Order Number:</strong> ${order.orderNumber}</p>
    <p><strong>Total:</strong> $${order.totalPrice.toFixed(2)}</p>
    <table style="width: 100%; border-collapse: collapse;">
      <thead>
        <tr>
          <th style="border: 1px solid #ddd; padding: 8px;">Product</th>
          <th style="border: 1px solid #ddd; padding: 8px;">Quantity</th>
          <th style="border: 1px solid #ddd; padding: 8px;">Price</th>
        </tr>
      </thead>
      <tbody>
        ${itemsHtml}
      </tbody>
    </table>
    <p>We'll notify you when your order is shipped.</p>
  `;

  await sendEmail({ to: user.email, subject, html });
};

/**
 * Send Order Shipped Email
 */
const sendOrderShipped = async (order, user) => {
  const subject = `Your Order Has Been Shipped - ${order.orderNumber}`;
  const html = `
    <h1>Your Order is on its way!</h1>
    <p>Hi ${user.name},</p>
    <p>Your order ${order.orderNumber} has been shipped.</p>
    ${order.trackingNumber ? `<p><strong>Tracking Number:</strong> ${order.trackingNumber}</p>` : ''}
    <p>Expected delivery: ${order.estimatedDelivery ? order.estimatedDelivery.toDateString() : 'Within 5-7 business days'}</p>
    <a href="${process.env.FRONTEND_URL}/orders/${order._id}" style="padding: 10px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 5px;">Track Order</a>
  `;

  await sendEmail({ to: user.email, subject, html });
};

/**
 * Send Order Delivered Email
 */
const sendOrderDelivered = async (order, user) => {
  const subject = `Your Order Has Been Delivered - ${order.orderNumber}`;
  const html = `
    <h1>Order Delivered!</h1>
    <p>Hi ${user.name},</p>
    <p>Your order ${order.orderNumber} has been delivered. We hope you enjoy your purchase!</p>
    <p>Please take a moment to leave a review for the products you purchased.</p>
    <a href="${process.env.FRONTEND_URL}/orders/${order._id}/review" style="padding: 10px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 5px;">Leave a Review</a>
  `;

  await sendEmail({ to: user.email, subject, html });
};

/**
 * Send Password Reset Email
 */
const sendPasswordReset = async (user, resetToken) => {
  const subject = 'Password Reset Request';
  const resetUrl = `${process.env.FRONTEND_URL}/reset-password/${resetToken}`;
  const html = `
    <h1>Password Reset</h1>
    <p>Hi ${user.name},</p>
    <p>We received a request to reset your password. Click the button below to reset it:</p>
    <a href="${resetUrl}" style="padding: 10px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 5px;">Reset Password</a>
    <p>This link will expire in 10 minutes.</p>
    <p>If you didn't request this, please ignore this email.</p>
  `;

  await sendEmail({ to: user.email, subject, html });
};

/**
 * Send Email Verification Email
 */
const sendVerificationEmail = async (user, verificationToken) => {
  const subject = 'Verify Your Email';
  const verifyUrl = `${process.env.FRONTEND_URL}/verify-email/${verificationToken}`;
  const html = `
    <h1>Verify Your Email</h1>
    <p>Hi ${user.name},</p>
    <p>Thank you for registering. Please verify your email address:</p>
    <a href="${verifyUrl}" style="padding: 10px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 5px;">Verify Email</a>
    <p>This link will expire in 24 hours.</p>
  `;

  await sendEmail({ to: user.email, subject, html });
};

/**
 * Send Seller Approval Email
 */
const sendSellerApproval = async (user, approved) => {
  const subject = approved ? 'Seller Account Approved!' : 'Seller Account Update';
  const html = approved ? `
    <h1>Congratulations!</h1>
    <p>Hi ${user.name},</p>
    <p>Your seller account has been approved! You can now start listing products and selling on Cartico.</p>
    <a href="${process.env.FRONTEND_URL}/seller/dashboard" style="padding: 10px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 5px;">Go to Seller Dashboard</a>
  ` : `
    <h1>Seller Account Update</h1>
    <p>Hi ${user.name},</p>
    <p>Your seller application has been reviewed. Unfortunately, we couldn't approve your request at this time.</p>
    <p>Reason: ${user.verificationReason || 'Please contact support for more information.'}</p>
    <p>You can reapply after 30 days.</p>
  `;

  await sendEmail({ to: user.email, subject, html });
};

module.exports = {
  sendEmail,
  sendWelcomeEmail,
  sendOrderConfirmation,
  sendOrderShipped,
  sendOrderDelivered,
  sendPasswordReset,
  sendVerificationEmail,
  sendSellerApproval
};