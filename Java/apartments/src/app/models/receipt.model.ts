import { Booking } from "./booking.model";

export class Receipt {
  id: number;
  isPaid: boolean;
  booking: Booking;

  constructor(id: number, isPaid: boolean, booking: Booking) {
    this.id = id;
    this.isPaid = isPaid;
    this.booking = booking;
  }
}
