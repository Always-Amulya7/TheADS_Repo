console.log("Initiating Script")

import express from "express";
const app = express();
const port = 3000;

app.use(express.static('public'))

//This Is Chaining Of Requests

app.get("/", (req, res) => {
  console.log("It's A Get Request");
  res.send("Hello World!");
}).post("/", (req, res) => {
  console.log("It's A Post Request");
  res.send("Hello Post World!");
});

app.get("/Server", (req, res) => {
    console.log("It's A Get Request");
    res.sendFile('Template/8-Requests.html',{root:__dirname});
  });

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});