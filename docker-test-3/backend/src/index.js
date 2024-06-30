"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express = require("express");
const mysql = require("mysql2");
const app = express();
const db_1 = __importDefault(require("./utils/db"));
const models_1 = require("./utils/models");
// console.log("DB_HOST:", process.env.DB_HOST);
// console.log("DB_USER:", process.env.DB_USER);
// console.log("DB_PASSWORD:", process.env.DB_PASSWORD);
// console.log("DB_DATABASE:", process.env.DB_DATABASE);
// console.log("DB_PORT:", process.env.DB_PORT);
app.use("/", (_, res) => __awaiter(void 0, void 0, void 0, function* () {
    const messages = yield models_1.Message.findAll({});
    if (messages) {
        const html = messages.map((item) => {
            return `<h1>Sequelize: ${item.msg}</h1>`;
        });
        return res.send(html.join(""));
    }
}));
const PORT = process.env.PORT ? process.env.PORT : 3000;
db_1.default
    .sync({ alter: true })
    .then(() => {
    app.listen(PORT, () => {
        console.log(`Server is running at port ${PORT}`);
    });
})
    .catch((err) => console.log(err));
