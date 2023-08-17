import { Component, Input, OnChanges } from "@angular/core";
import { DataService } from "@pages/apartments/services/data.service";
import { Receipt, Room } from "@app/models";

@Component({
  selector: "apartment-details",
  templateUrl: "./apartment-details.component.html",
  styleUrls: ["./apartment-details.component.scss"]
})
export class ApartmentDetailsComponent implements OnChanges {
  @Input() apartment?: Room;
  receipt?: Receipt;

  constructor(private dataService: DataService) {}

  ngOnChanges() {
    if (this.apartment) {
      this.receipt = this.getLatestReceipt(this.apartment?.id);
    }
  }

  getLatestReceipt(roomId: number): Receipt {
    const receipts = this.dataService.receipts.filter(receipt => {
      return receipt.booking.id === roomId;
    });
    return receipts[receipts.length - 1];
  }
}
