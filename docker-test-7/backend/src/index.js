const express = require("express");

const app = express();

const mongoose = require("mongoose");

app.use("/", (req, res) => {
  return res.send("<h1> Hello World!</h1>");
});

const PORT = process.env.PORT || "3000";

const username = process.env.DB_USER;
const password = process.env.DB_PASSWORD;
const host = process.env.DB_HOST;
const port = process.env.DB_PORT;
const database = process.env.DB_NAME;

const uriString = `mongodb://${username}:${password}@${host}:${port}/${database}?authSource=admin`;

console.log(`\n\n\n${uriString}\n\n\n`);

mongoose
  .connect(uriString, { useNewUrlParser: true, useUnifiedTopology: true })
  .then((db) => {
    console.log(db.c);
    console.log("Conectado ao mongodb com sucesso");
  })
  .catch((err) => {
    console.log("Erro ao conectar ao mongodb", err);
  });
app.listen(PORT, () => {
  console.log(`Server is running at port ${PORT}`);
});
