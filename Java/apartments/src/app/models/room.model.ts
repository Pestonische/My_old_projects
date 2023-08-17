import { RoomType } from "./room-type.enum";

export class Room {
  id: number;
  capacity: number;
  price: number;
  type: RoomType;

  constructor(id: number, capacity: number, price: number, type: RoomType) {
    this.id = id;
    this.capacity = capacity;
    this.price = price;
    this.type = type;
  }
}
