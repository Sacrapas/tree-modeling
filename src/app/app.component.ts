import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent {


  @Input() name: string;

  @Input() children: any[];


  public cells: any[] = [
    {
      id: 0,
      name: 'сенсоры',
      links: [3]
    },
    {
      name: 'мозг',
      children: [
        {
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

  public add(e: Event): void {
    this.children.push({
      name:     null,
      children: null
    });
    e.stopPropagation();
  }

}
