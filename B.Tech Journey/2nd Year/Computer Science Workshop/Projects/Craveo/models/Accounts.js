const mongoose = require("mongoose");
const accountSchema = new mongoose.Schema(
  {
    userId: {
      type: String,
      required: true,
      unique: true,
      trim: true,
    },
    password: {
      type: String,
      required: true,
    },
  },
  { collection: "Account Handles" }
);
module.exports = (connection) => connection.model("Accounts", accountSchema);
