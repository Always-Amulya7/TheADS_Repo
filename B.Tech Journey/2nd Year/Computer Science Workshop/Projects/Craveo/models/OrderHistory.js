const mongoose = require("mongoose");
const orderSchema = new mongoose.Schema(
  {
    userId: String,
    items: [
      {
        image: String,
        name: String,
        price: Number,
        quantity: Number,
      },
    ],
    total: Number,
    date: { type: Date, default: Date.now },
  },
  { collection: "Order History" }
);
module.exports = (conn) => conn.model("OrderHistory", orderSchema);
