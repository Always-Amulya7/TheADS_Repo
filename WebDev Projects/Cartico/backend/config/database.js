/**
 * MongoDB Database Configuration
 * Handles connection and event listeners
 */

const mongoose = require('mongoose');

const connectDB = async () => {
  try {
    const conn = await mongoose.connect(process.env.MONGODB_URI);
    console.log(`MongoDB Connected: ${conn.connection.host}`);
    
    // Connection events
    mongoose.connection.on('error', (err) => {
      console.error('MongoDB Connection Error:', err);
    });
    
    mongoose.connection.on('disconnected', () => {
      console.log('MongoDB Disconnected');
    });
    
    mongoose.connection.on('reconnected', () => {
      console.log('MongoDB Reconnected');
    });
    
  } catch (error) {
    console.error(`Error: ${error.message}`);
    process.exit(1);
  }
};

module.exports = connectDB;