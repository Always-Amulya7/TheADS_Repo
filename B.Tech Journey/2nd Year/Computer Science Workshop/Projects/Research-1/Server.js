//Integrating MongoDB

const express = require("express");
const path = require("path");
const bodyParser = require("body-parser");
const mongoose = require("mongoose");
const session = require("express-session");

const app = express();
const PORT = 3000;

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static(path.join(__dirname)));
app.use(
  session({
    secret: "your_secret_key",
    resave: false,
    saveUninitialized: true,
    cookie: { secure: false },
  })
);

mongoose
  .connect("mongodb://127.0.0.1:27017/AutoTalk", {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => console.log("Connected To Mongo DataBase"))
  .catch((err) => console.error("Mongo DataBase Connection Error:", err));

const userSchema = new mongoose.Schema({
  username: { type: String, required: true, unique: true },
  password: { type: String, required: true },
});

const User = mongoose.model("User", userSchema);

app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "Sign Up", "index.html"));
});

app.get("/Login", (req, res) => {
  res.sendFile(path.join(__dirname, "Login", "index.html"));
});

app.post("/signup", async (req, res) => {
  const { username, password } = req.body;
  try {
    const user = new User({ username, password });
    await user.save();
    res.status(201).send({ message: "User Signed Up Successfully" });
  } catch (error) {
    res.status(400).send({ error: "Username Already Exists Or Invalid Data" });
  }
});

app.post("/login", async (req, res) => {
  const { username, password } = req.body;
  try {
    const user = await User.findOne({ username, password });
    if (user) {
      req.session.username = user.username;
      res.status(200).send({ message: "Login Successful" });
    } else {
      res.status(401).send({ error: "Invalid Username Or Password" });
    }
  } catch (error) {
    res.status(500).send({ error: "Server Error" });
  }
});

app.get("/get-username", (req, res) => {
  if (req.session.username) {
    res.status(200).send({ username: req.session.username });
  } else {
    res.status(401).send({ error: "No User Logged In" });
  }
});

console.log("This Has Digital Rights");
console.log("Developer - Amulya Shrivastava");

app.listen(PORT, () => {
  console.log(`Server Is Running On http://localhost:${PORT}`);
});

//Using Local Cache

// const express = require('express');
// const path = require('path');

// const app = express();
// const PORT = 3000;

// // Serve static files from the main project directory
// app.use(express.static(path.join(__dirname)));

// // Default route that serves the Sign Up page directly
// app.get('/', (req, res) => {
//     res.sendFile(path.join(__dirname, 'Sign Up', 'index.html'));
// });

// // Route for the Sign Up page (optional, in case you need it separately)
// app.get('/SignUp', (req, res) => {
//     res.sendFile(path.join(__dirname, 'Sign Up', 'index.html'));
// });

// // Route for the Login page
// app.get('/Login', (req, res) => {
//     res.sendFile(path.join(__dirname, 'Login', 'index.html'));
// });

// // Route for the Connectivity Page page
// app.get('/Connectivity', (req, res) => {
//     res.sendFile(path.join(__dirname, 'Connectivity', 'index.html'));
// });

// // Route for the Meeting page
// app.get('/Meeting', (req, res) => {
//     res.sendFile(path.join(__dirname, 'Meeting', 'index.html'));
// });

// // Start the server
// app.listen(PORT, () => {
//     console.log(`Server is running on http://localhost:${PORT}`);
// });

//Experiment-1

// const express = require('express');
// const mongoose = require('mongoose');
// const path = require('path');
// const bodyParser = require('body-parser');
// const app = express();
// const PORT = 3000;

// // MongoDB Connection
// mongoose.connect('mongodb://127.0.0.1:27017/AutoTalk', {
//   useNewUrlParser: true,
//   useUnifiedTopology: true,
// }).then(() => {
//   console.log('MongoDB Initiated');
// }).catch((err) => {
//   console.error('MongoDB Connection Error:', err);
// });

// // MongoDB Schema and Model
// const userSchema = new mongoose.Schema({
//   username: { type: String, required: true, unique: true },
//   password: { type: String, required: true },
// });
// const User = mongoose.model('User', userSchema);

// // Middleware
// app.use(express.static(path.join(__dirname))); // Serve static files
// app.use(bodyParser.json()); // Parse JSON body

// // Default route serving Sign Up page
// app.get('/', (req, res) => {
//   res.sendFile(path.join(__dirname, 'Sign Up', 'index.html'));
// });

// // Route to handle Sign Up form submission
// app.post('/signup', async (req, res) => {
//   const { username, password } = req.body;

//   try {
//     if (!username || !password) {
//       return res.status(400).json({ message: 'Username And Password Are Required' });
//     }

//     const newUser = new User({ username, password });
//     await newUser.save(); // Save to MongoDB
//     res.status(201).json({ message: 'User Registered Successfully' });
//   } catch (error) {
//     if (error.code === 11000) { // Duplicate key error
//       res.status(400).json({ message: 'Username Already Exists' });
//     } else {
//       res.status(500).json({ message: 'Server Error', error });
//     }
//   }
// });

// // Start the server
// app.listen(PORT, () => {
//   console.log(`Server is running on http://localhost:${PORT}`);
// });