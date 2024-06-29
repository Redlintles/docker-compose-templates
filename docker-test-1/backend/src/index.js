const express = require("express");
const mysql = require("mysql2");

const app = express();

console.log("DB_HOST:", process.env.DB_HOST);
console.log("DB_USER:", process.env.DB_USER);
console.log("DB_PASSWORD:", process.env.DB_PASSWORD);
console.log("DB_DATABASE:", process.env.DB_DATABASE);
console.log("DB_PORT:", process.env.DB_PORT);

const conn = mysql.createConnection({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_DATABASE,
  port: process.env.DB_PORT,
});

const PORT = process.env.PORT || 3000;

conn.connect((err) => {
  if (err) {
    console.log("Erro ao conectar ao banco de dados: ", err.stack);
    return;
  }

  console.log("Conectado ao banco de dados com sucesso!");

  app.use("/", (req, res) => {
    return res.json({
      message: "Conectado com sucesso",
      conn,
    });
  });

  app.listen(PORT, () => {
    console.log(`Server is running at port ${PORT}`);
  });
});
