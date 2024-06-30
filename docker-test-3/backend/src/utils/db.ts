import { Sequelize } from "sequelize";

const sequelize = new Sequelize(
  process.env.DB_DATABASE || "test",
  process.env.DB_USER || "root",
  process.env.DB_PASSWORD || "banana_02",
  {
    dialect: "mysql",
    host: process.env.DB_HOST || "localhost",
    port: parseInt(process.env.DB_PORT || "3000"),
  }
);

export default sequelize;
