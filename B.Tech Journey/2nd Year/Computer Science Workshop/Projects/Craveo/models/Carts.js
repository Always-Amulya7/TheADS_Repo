const mongoose = require("mongoose");
const cartSchema = new mongoose.Schema(
  {
    userId: { type: String, required: true },
    image: String,
    name: String,
    price: Number,
    quantity: Number,
  },
  { collection: "Cart Updates" }
);
module.exports = (connection) => connection.model("CartItem", cartSchema);
