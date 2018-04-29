import { Component } from '@angular/core';
import {Tree} from '@app/models/tree';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent {

  public cells: Tree = [
  {
    id: 0,
    name: 'сенсоры',
    links: [3]
  },
  {
    id: 1,
    name: 'мозг',
    children: [
      {
        id: 2,
        name: 'память',
        children: [
          {
            name: 'текущая',
            id: 3,
            links: [4]
          },
          {
            name: 'долговременная',
            id: 4,
            links: [3]
          }
        ]
      },
      {
        name: 'таблица приоритетов',
        links: [5]
      },
      {
        name: 'модуль достижения цели',
        id: 5,
        links: [6]
      }
    ]
  },
  {
    name: 'кнопки',
    id: 6
  }
];
}
