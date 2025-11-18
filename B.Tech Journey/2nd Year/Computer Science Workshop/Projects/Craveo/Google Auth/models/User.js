const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
  googleId: String,
  name: String,
  email: String,
  image: String
});

module.exports = mongoose.model('User', userSchema);