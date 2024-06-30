"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.Message = void 0;
const sequelize_1 = require("sequelize");
const db_1 = __importDefault(require("./db"));
// @ts-ignore
const message_1 = __importDefault(require("../models/message"));
exports.Message = (0, message_1.default)(db_1.default, sequelize_1.DataTypes);
