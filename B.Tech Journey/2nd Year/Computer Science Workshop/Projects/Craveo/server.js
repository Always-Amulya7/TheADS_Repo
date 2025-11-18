const express = require("express");
const mongoose = require("mongoose");
const cors = require("cors");
const path = require("path");
const multer = require("multer");
const createCartModel = require("./models/Carts");
const createOrderHistoryModel = require("./models/OrderHistory");
const createDineRequestModel = require("./models/DineRequest");
const app = express();
const PORT = process.env.PORT || 3000;
app.use(cors());
app.use(express.json({ limit: "10mb" }));
app.use(express.urlencoded({ extended: true, limit: "10mb" }));
app.use(express.static(path.join(__dirname, "public")));
const conn = mongoose.createConnection("mongodb://127.0.0.1:27017/Craveo", {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});
let Carts, Orders, DineRequests;
conn.once("open", () => {
  console.log("✅ Connected to MongoDB: Craveo");
  Carts = createCartModel(conn);
  Orders = createOrderHistoryModel(conn);
  DineRequests = createDineRequestModel(conn);
});
const storage = multer.memoryStorage();
const upload = multer({ storage });
app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "index.html"));
});
app.get("/cart", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "cart.html"));
});
app.post(
  "/api/dineinrequest",
  upload.single("profile-pic"),
  async (req, res) => {
    try {
      const {
        fullname,
        email,
        birthdate,
        gender,
        Selection: restroloc,
        bio,
        referralSource,
      } = req.body;
      let purpose = req.body.interests;
      if (!Array.isArray(purpose)) purpose = purpose ? [purpose] : [];
      let profilePic = null;
      if (req.file) {
        profilePic = {
          data: req.file.buffer,
          contentType: req.file.mimetype,
        };
      }
      const newRequest = new DineRequests({
        fullname,
        email,
        birthdate,
        gender,
        restroloc,
        purpose,
        bio,
        referralSource,
        profilePic,
      });
      await newRequest.save();
      res.status(201).send("Dine-in request submitted successfully!");
    } catch (err) {
      console.error("❌ Dine-in request error:", err.message);
      res.status(500).send("Failed to submit request");
    }
  }
);
app.post("/api/Carts", async (req, res) => {
  try {
    const { userId, image, name, price, quantity = 1 } = req.body;
    if (!Carts)
      return res.status(500).json({ error: "Cart DB not initialized" });
    if (!userId || !image || !name || !price) {
      return res.status(400).json({ error: "Missing required fields" });
    }
    const existing = await Carts.findOne({ userId, name });
    if (existing) {
      existing.quantity += quantity;
      await existing.save();
      return res
        .status(200)
        .json({ message: "Quantity updated", item: existing });
    }
    const newItem = new Carts({ userId, image, name, price, quantity });
    await newItem.save();
    res.status(201).json({ message: "Item added", item: newItem });
  } catch (err) {
    res.status(500).json({ error: "Failed to add item", details: err.message });
  }
});
app.get("/api/Carts/:userId", async (req, res) => {
  try {
    if (!Carts)
      return res.status(500).json({ error: "Cart DB not initialized" });
    const cartItems = await Carts.find({ userId: req.params.userId });
    res.status(200).json(cartItems);
  } catch (err) {
    res
      .status(500)
      .json({ error: "Failed to fetch cart", details: err.message });
  }
});
app.put("/api/Carts/:id", async (req, res) => {
  try {
    if (!Carts)
      return res.status(500).json({ error: "Cart DB not initialized" });
    const item = await Carts.findById(req.params.id);
    if (!item) return res.status(404).json({ error: "Item not found" });
    item.quantity = req.body.quantity;
    await item.save();
    res.status(200).json({ message: "Quantity updated", item });
  } catch (err) {
    res
      .status(500)
      .json({ error: "Failed to update quantity", details: err.message });
  }
});
app.delete("/api/Carts/:id", async (req, res) => {
  try {
    if (!Carts)
      return res.status(500).json({ error: "Cart DB not initialized" });
    await Carts.findByIdAndDelete(req.params.id);
    res.status(200).json({ message: "Item deleted" });
  } catch (err) {
    res
      .status(500)
      .json({ error: "Failed to delete item", details: err.message });
  }
});
app.delete("/api/Carts/clear/:userId", async (req, res) => {
  try {
    const userId = req.params.userId;
    if (!Carts || !Orders)
      return res.status(500).json({ error: "DBs not initialized" });
    const cartItems = await Carts.find({ userId });
    if (!cartItems.length)
      return res.status(200).json({ message: "Cart already empty" });
    const orderData = new Orders({ userId, items: cartItems });
    await orderData.save();
    await Carts.deleteMany({ userId });
    res.status(200).json({ message: "Cart cleared and order stored" });
  } catch (err) {
    res
      .status(500)
      .json({
        error: "Failed to clear cart and save order",
        details: err.message,
      });
  }
});
app.get("/api/Orders/:userId", async (req, res) => {
  try {
    if (!Orders)
      return res.status(500).json({ error: "Order DB not initialized" });
    const history = await Orders.find({ userId: req.params.userId }).sort({
      createdAt: -1,
    });
    res.status(200).json(history);
  } catch (err) {
    res
      .status(500)
      .json({ error: "Failed to fetch order history", details: err.message });
  }
});
app.listen(PORT, () => {
  console.log(`🚀 Server running at http://localhost:${PORT}`);
});
