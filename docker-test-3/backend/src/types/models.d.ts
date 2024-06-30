import { Model } from "sequelize";

declare module "models" {
  export interface Message extends Model {}
}
