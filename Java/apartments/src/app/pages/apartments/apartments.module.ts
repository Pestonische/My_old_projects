import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { ReactiveFormsModule } from "@angular/forms";

import { ApartmentsComponent } from "./apartments.component";
import { ApartmentsListComponent } from "./components/apartments-list/apartments-list.component";
import { ApartmentDetailsComponent } from "./components/apartment-details/apartment-details.component";
import { AddApartmentFormComponent } from "./components/add-apartment-form/add-apartment-form.component";

import { DataService } from "./services/data.service";
import { ApartmentsRoutingModule } from "./apartments-routing.module";


@NgModule({
  declarations: [ApartmentsComponent, ApartmentsListComponent, ApartmentDetailsComponent, AddApartmentFormComponent],
  imports: [
    CommonModule,
    ApartmentsRoutingModule,
    ReactiveFormsModule,
  ],
  providers: [DataService]
})
export class ApartmentsModule {}
