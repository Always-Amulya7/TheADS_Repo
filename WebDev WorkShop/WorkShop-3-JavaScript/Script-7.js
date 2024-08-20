import express from "express";
const app = express();
const port = 3000;

app.use(express.static('public'))

app.get("/", (req, res) => {
  res.send("Hello World!");
});

app.get("/About", (req, res) => {
  res.send("Amulya Shrivastava");
});

app.get("/Blog", (req, res) => {
  res.send("This Is The Blog");
});

app.get("/Contact", (req, res) => {
  res.send("Contact Info Here!!");
});

app.get("/Blog/:slug", (req, res) => {
    res.send(`Hello ${req.params.slug}`);
  });

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
