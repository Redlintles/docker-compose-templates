import { DataTypes } from "sequelize";
import sequelize from "./db";

// @ts-ignore
import MessageFn from "../models/message";

export const Message = MessageFn(sequelize, DataTypes);
