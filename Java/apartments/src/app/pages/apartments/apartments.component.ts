import { Component, OnDestroy, OnInit } from "@angular/core";
import { DataService } from "./services/data.service";
import { Subject } from "rxjs";
import { Room } from "@app/models";
import { takeUntil } from "rxjs/operators";


@Component({
  selector: "apartments-page",
  templateUrl: "./apartments.component.html",
  styleUrls: ["./apartments.component.scss"],
})
export class ApartmentsComponent implements OnInit, OnDestroy {
  private destroy = new Subject();
  apartments: Room[] = [];

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.dataService.apartments$
      .pipe(takeUntil(this.destroy))
      .subscribe((apartments) => {
        this.apartments = apartments;
      });
  }

  ngOnDestroy() {
    this.destroy.next(true);
  }
}
