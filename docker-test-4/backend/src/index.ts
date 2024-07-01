const express = require("express");
const mysql = require("mysql2");

const app = express();

import { NextFunction, Request, Response } from "express";
import sequelize from "./utils/db";
import { Message } from "./utils/models";
import cors from "cors";
// console.log("DB_HOST:", process.env.DB_HOST);
// console.log("DB_USER:", process.env.DB_USER);
// console.log("DB_PASSWORD:", process.env.DB_PASSWORD);
// console.log("DB_DATABASE:", process.env.DB_DATABASE);
// console.log("DB_PORT:", process.env.DB_PORT);

const corsOptions = {
  origin: "*", // Ensure this matches your NGINX server_name
  methods: ["GET", "POST", "PUT", "DELETE", "OPTIONS"],
  credentials: true,
  optionsSuccessStatus: 204,
};

app.use(cors(corsOptions));

app.use("/api", async (req: Request, res: Response) => {
  const messages = await Message.findAll({});

  console.log(req.originalUrl);

  if (messages) {
    const result: string[] = messages.map((item: any) => {
      return `Sequelize: ${item.msg}`;
    });

    return res.status(200).json({
      error: false,
      data: result,
    });
  }
});

app.use("/healthcheck", (_: Request, res: Response) => {
  return res.send("OK");
});

const PORT = process.env.PORT ? process.env.PORT : 5000;

sequelize
  .sync({ alter: true })
  .then(() => {
    app.listen(PORT, () => {
      console.log(`Server is running at port ${PORT}`);
    });
  })
  .catch((err) => console.log(err));
