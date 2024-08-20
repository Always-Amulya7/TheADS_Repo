import mongoose from "mongoose";
import express from "express";
import { Todo } from "./models/ToDo.js";

let Conn = await mongoose.connect("mongodb://localhost:27017/");
const app = express();
const port = 3000;

/* app.get("/", (req, res) => {
  const ToDo = new Todo({title: "Amulya Wev Dev",desc: "He Is King Ping",isDone: false,
  });
  ToDo.save();
  res.send("Hello World!");
}); */

app.get("/", (req, res) => {
  /* const ToDo = new Todo({title: "Amulya Wev Dev",desc: "He Is King Ping",isDone: false,
  });
  ToDo.save(); */

  res.send("Hello World!");
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
