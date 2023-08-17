const express = require("express");
const path = require("path");

const app = express();

app.use(express.static("./dist/apartments"));

app.get("/*", (req, res) =>
  res.sendFile("index.html", { root: "dist/apartments/" }),
);

app.listen(process.env.PORT || 8080);

console.log("Server started!");
console.log("Debug link: http://localhost:8080");
