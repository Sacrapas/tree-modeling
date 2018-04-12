import { Component, OnInit, Input, HostListener } from '@angular/core';

@Component({
  selector: 'app-cell',
  templateUrl: 'cell.component.html',
  styleUrls: ['cell.component.scss']
})
export class CellComponent {

  @Input() name: string;

  @Input() children: any[];

  public add(e: Event): void {
    this.children.push(1);
    console.log(this.children);
    e.stopPropagation();
  }


}
