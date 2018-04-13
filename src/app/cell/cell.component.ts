import {Component, Input, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-cell',
  templateUrl: 'cell.component.html',
  styleUrls: ['cell.component.scss']
})
export class CellComponent {

  @Input()  children:     any[];
  @Input()  depth:        number;
  @Input()  name:         string;
  @Input()  selfIndex:    number;

  @Output() destroySelf: EventEmitter<number> = new EventEmitter<number>();

  public isCollapsed = true;

  public add(): void {
    this.children.push({name: null});
    this.isCollapsed = false;
  }

  public switchCollapse(): void {
    this.isCollapsed = !this.isCollapsed;
  }

  public sp(e: Event): void {
    e.stopPropagation();
  }

  public destroyChild(i: number): void {
    this.children = [...this.children.slice(0, i), ...this.children.slice(i + 1, this.children.length)];
  }
}
