import { Booking } from "@app/models";
import { ClientMock } from "./client.mock";
import { RoomMock } from "./room.mock";

export const BookingMock = [
  new Booking(
    0,
    2,
    new Date("2022-03-19"),
    new Date("2022-03-21"),
    ClientMock[0],
    RoomMock[3],
    true
  ),
  new Booking(
    1,
    2,
    new Date("2022-03-16"),
    new Date("2022-03-20"),
    ClientMock[0],
    RoomMock[5],
    true
  ),
  new Booking(
    2,
    1,
    new Date("2022-03-15"),
    new Date("2022-03-24"),
    ClientMock[0],
    RoomMock[7],
    true
  ),
  new Booking(
    3,
    1,
    new Date("2022-03-17"),
    new Date("2022-03-28"),
    ClientMock[2],
    RoomMock[8],
    true
  ),
  new Booking(
    4,
    1,
    new Date("2022-03-15"),
    new Date("2022-03-20"),
    ClientMock[3],
    RoomMock[0],
    true
  ),
  new Booking(5,
    2,
    new Date("2022-03-21"),
    new Date("2022-03-25"),
    ClientMock[0],
    RoomMock[3],
    true
  ),
  new Booking(
    6,
    4,
    new Date("2022-03-16"),
    new Date("2022-04-06"),
    ClientMock[0],
    RoomMock[6],
    true
  ),
  new Booking(
    7,
    2,
    new Date("2022-03-20"),
    new Date("2022-03-30"),
    ClientMock[0],
    RoomMock[5],
    true
  ),
  new Booking(
    8,
    6,
    new Date("2022-03-28"),
    new Date("2022-04-01"),
    ClientMock[0],
    RoomMock[8],
    true
  ),
  new Booking(
    9,
    3,
    new Date("2022-04-01"),
    new Date("2022-04-12"),
    ClientMock[0],
    RoomMock[1],
    true,
  ),
  new Booking(
    10,
    1,
    new Date("2022-03-20"),
    new Date("2022-03-29"),
    ClientMock[0],
    RoomMock[0],
    true
  ),
  new Booking(
    11,
    1,
    new Date("2022-04-02"),
    new Date("2022-04-16"),
    ClientMock[0],
    RoomMock[2],
    true,
    ),
  new Booking(
    12,
    1,
    new Date("2022-03-30"),
    new Date("2022-04-10"),
    ClientMock[0],
    RoomMock[0]
  ),
  new Booking(
    13,
    2,
    new Date("2022-03-31"),
    new Date("2022-04-05"),
    ClientMock[0],
    RoomMock[4],
    true,
    )
];
