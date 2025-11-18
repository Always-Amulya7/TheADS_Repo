const mongoose = require("mongoose");
const dineRequestSchema = new mongoose.Schema({
  fullname: String,
  email: String,
  birthdate: Date,
  gender: String,
  restroloc: String,
  purpose: [String],
  bio: String,
  referralSource: String,
  profilePic: {
    data: Buffer,
    contentType: String,
  },
  timestamp: {
    type: Date,
    default: Date.now,
  },
});
module.exports = (connection) =>
  connection.model("DineRequest", dineRequestSchema, "Dine Requests");
