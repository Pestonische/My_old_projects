import { Component } from "@angular/core";
import { DataService } from "@pages/apartments/services/data.service";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { RoomType } from "@models/room-type.enum";
import { Room } from "@app/models";


@Component({
  selector: "add-apartment-form",
  templateUrl: "./add-apartment-form.component.html",
  styleUrls: ["./add-apartment-form.component.scss"],
})
export class AddApartmentFormComponent {
  roomTypes: RoomType[] = [RoomType.STANDARD, RoomType.SINGLE, RoomType.SUITE, RoomType.FAMILY];

  form: FormGroup = new FormGroup({
    capacity: new FormControl(0, [
      Validators.required,
      Validators.min(1)
    ]),
    price: new FormControl(0, [
      Validators.required,
      Validators.min(300)
    ]),
    type: new FormControl('', [
      Validators.required,
    ]),
  });

  constructor(private dataService: DataService) {}

  onSubmit() {
    const formData = this.form.value;
    const apartment = new Room(
      this.dataService.apartments.length,
      formData.capacity,
      formData.price,
      formData.type,
    );
    this.dataService.setApartment(apartment);
  }
}
