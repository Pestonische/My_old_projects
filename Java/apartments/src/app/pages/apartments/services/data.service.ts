import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable } from "rxjs";
import { Room, Receipt } from "@app/models";
import { RoomMock, ReceiptMock } from "@app/mocks";


@Injectable()
export class DataService {
  private apartmentData = new BehaviorSubject<Room[]>([]);
  private receiptData = new BehaviorSubject<Receipt[]>([]);

  get receipts$(): Observable<Receipt[]> {
    return this.receiptData.asObservable();
  }

  get receipts(): Receipt[] {
    return this.receiptData.value;
  }

  get apartments$(): Observable<Room[]> {
    return this.apartmentData.asObservable();
  }

  get apartments(): Room[] {
    return this.apartmentData.value;
  }

  constructor() {
    this.setReceipts(ReceiptMock);
    this.setApartments(RoomMock);
  }

  setReceipts(receipts: Receipt[]) {
    const receiptData = this.receiptData.value;
    this.receiptData.next([...receipts, ...receiptData]);
  }

  setApartment(apartment: Room) {
    const apartmentData = this.apartmentData.value;
    this.apartmentData.next([apartment, ...apartmentData]);
  }

  setApartments(apartments: Room[]) {
    const apartmentData = this.apartmentData.value;
    this.apartmentData.next([...apartments, ...apartmentData]);
  }
}
