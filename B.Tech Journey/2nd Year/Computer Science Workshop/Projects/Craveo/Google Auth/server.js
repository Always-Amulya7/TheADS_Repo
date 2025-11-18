const express = require('express');
const passport = require('passport');
const session = require('express-session');
const mongoose = require('mongoose');
require('./Google Auth/config/passport');
const app = express();
// MongoDB connection
mongoose.connect('mongodb://localhost:27017/carveo_users', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
}).then(() => console.log('MongoDB Connected'))
  .catch(err => console.log(err));

// Sessions
app.use(session({
  secret: 'someSecretKey',
  resave: false,
  saveUninitialized: false
}));

// Passport
app.use(passport.initialize());
app.use(passport.session());

// Routes
app.get('/auth/google',
  passport.authenticate('google', { scope: ['profile', 'email'] }));

app.get('/auth/google/callback',
  passport.authenticate('google', {
    failureRedirect: '/',
    successRedirect: '/profile'
  }));

app.get('/profile', (req, res) => {
  if (!req.user) return res.redirect('/');
  res.send(`<h1>Hello ${req.user.name}</h1><p>Email: ${req.user.email}</p><img src="${req.user.image}" width="100">`);
});

// Static files
app.use(express.static(__dirname + '/public'));

// Start Server
app.listen(3000, () => console.log('Server running on http://localhost:3000'));
