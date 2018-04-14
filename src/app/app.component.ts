import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {StateService} from './state.service';
import {isNil} from 'lodash';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent implements OnChanges {


  @Input() name: string;
  @Input() children: any[];
  @Input() depth;

  constructor(public readonly state: StateService) {
    this.children = state.cells;
  }

  ngOnChanges(val: SimpleChanges) {
    this.children = val.children as any;
  }

  public add(e: Event): void {
    this.children.push({
      name:     null,
      children: null
    });
    e.stopPropagation();
  }

}
