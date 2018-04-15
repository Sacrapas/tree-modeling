import {Component, Input, Output, EventEmitter} from '@angular/core';
import {isNil} from 'lodash';

@Component({
  selector:    'app-cell',
  templateUrl: 'cell.component.html',
  styleUrls:  ['cell.component.scss']
})
export class CellComponent {

  @Input()  children:    any[];
  @Input()  depth:       number;
  @Input()  selfIndex:   number;
  @Input()  name:        string;
  @Output() nameChange:  EventEmitter<string> = new EventEmitter<string>();
  @Output() childrenChange: EventEmitter<any[]> = new EventEmitter<any[]>();
  @Output() destroySelf: EventEmitter<number> = new EventEmitter<number>();

  public isCollapsed = true;

  public inputChange(e: string): void {
    this.nameChange.emit(e);
  }

  public add(): void {
    if (isNil(this.children)) {
      this.children = [];
    }
    this.children.push({name: this.depth});
    this.childrenChange.emit(this.children);
    this.isCollapsed = false;
  }

  public switchCollapse(): void {
    this.isCollapsed = !this.isCollapsed;
  }

  public sp(e: Event): void {
    e.stopPropagation();
  }

  public destroyChild(i: number): void {
    this.children.splice(i, 1);
  }
}
