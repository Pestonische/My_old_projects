import { Client } from "./client.model";
import { Room } from "./room.model";

export class Booking {
  id: number;
  guests: number;
  arrivalTime: Date;
  departureTime: Date;
  client: Client;
  room: Room;
  isConfirmed: boolean;

  constructor(
    id: number,
    guests: number,
    arrivalTime: Date,
    departureTime: Date,
    client: Client,
    room: Room,
    isConfirmed = false
  ) {
    this.id = id;
    this.guests = guests;
    this.arrivalTime = arrivalTime;
    this.departureTime = departureTime;
    this.client = client;
    this.room = room;
    this.isConfirmed = isConfirmed;
  }
}
