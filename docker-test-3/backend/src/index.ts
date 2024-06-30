const express = require("express");
const mysql = require("mysql2");

const app = express();

import { Request, Response } from "express";
import sequelize from "./utils/db";
import { Message } from "./utils/models";

// console.log("DB_HOST:", process.env.DB_HOST);
// console.log("DB_USER:", process.env.DB_USER);
// console.log("DB_PASSWORD:", process.env.DB_PASSWORD);
// console.log("DB_DATABASE:", process.env.DB_DATABASE);
// console.log("DB_PORT:", process.env.DB_PORT);

app.use("/", async (_: Request, res: Response) => {
  const messages = await Message.findAll({});

  if (messages) {
    const html: string[] = messages.map((item: any) => {
      return `<h1>Sequelize: ${item.msg}</h1>`;
    });

    return res.json({
      error: false,
      code: html,
    });
  }
});

const PORT = process.env.PORT ? process.env.PORT : 3000;

sequelize
  .sync({ alter: true })
  .then(() => {
    app.listen(PORT, () => {
      console.log(`Server is running at port ${PORT}`);
    });
  })
  .catch((err) => console.log(err));
