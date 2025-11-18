const express = require("express");
const mongoose = require("mongoose");
const bodyParser = require("body-parser");
const path = require("path");

const app = express();

app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static(path.join(__dirname)));

mongoose
  .connect("mongodb://127.0.0.1:27017/Admin_Login", {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => console.log("Connected to MongoDB"))
  .catch((err) => console.error("MongoDB connection error:", err));

const adminSchema = new mongoose.Schema({
  username: { type: String, required: true },
  password: { type: String, required: true },
});

const Admin = mongoose.model("Admin", adminSchema);

app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "index.html"));
});

app.post("/login", async (req, res) => {
  const { username, password } = req.body;

  try {
    const admin = await Admin.findOne({ username, password });

    if (admin) {
      res.redirect("http://localhost:10745");
    } else {
      res.redirect("/");
    }
  } catch (error) {
    console.error("Error During Login:", error);
    res.status(500).send("Internal Server Error");
  }
});

app.post("/reset-password", (req, res) => {
  const { email } = req.body;
  console.log(`Password Reset Request For Email : ${email}`);
  res.send("<h1>Password Reset Instructions Sent To Your Email!</h1>");
});

const PORT = 4000;
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
