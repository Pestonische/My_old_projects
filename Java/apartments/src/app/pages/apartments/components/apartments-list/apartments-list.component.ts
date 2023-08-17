import { Component, Input } from "@angular/core";
import { Room } from "@app/models";


@Component({
  selector: 'apartments-list',
  templateUrl: './apartments-list.component.html',
  styleUrls: ['./apartments-list.component.scss']
})
export class ApartmentsListComponent {
  @Input() items: Room[] = [];
  activeItem = -1;

  onItemClick(index: number) {
    this.activeItem = this.activeItem == index ? -1: index;
  }
}
