import { Injectable } from '@angular/core';

@Injectable()
export class StateService {

  constructor() { }

  public cells: any[] = [
    {
      id: 0,
      name: 'сенсоры',
      links: [3],
      children: []
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
              links: [4],
              children: []
            },
            {
              name: 'долговременная',
              id: 4,
              links: [3],
              children: []
            }
          ]
        },
        {
          name: 'таблица приоритетов',
          links: [5],
          children: []
        },
        {
          name: 'модуль достижения цели',
          id: 5,
          links: [6],
          children: []
        }
      ]
    },
    {
      name: 'кнопки',
      id: 6,
      children: []
    }
  ];
}
