import { Room } from "@app/models";
import { RoomType } from "@models/room-type.enum";

export const RoomMock = [
  new Room(0, 1, 300, RoomType.SINGLE),
  new Room(1, 4, 550, RoomType.SUITE),
  new Room(2, 1, 800, RoomType.SINGLE),
  new Room(3, 2, 300, RoomType.STANDARD),
  new Room(4, 4, 550, RoomType.SUITE),
  new Room(5, 2, 300, RoomType.STANDARD),
  new Room(6, 4, 550, RoomType.SUITE),
  new Room(7, 2, 300, RoomType.STANDARD),
  new Room(8, 6, 800, RoomType.FAMILY),
]
