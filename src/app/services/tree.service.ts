import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Page} from '@app/models/page';
import {Tree} from '@app/models/tree';
import {HttpClient, HttpParams} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {of} from 'rxjs/observable/of';


@Injectable()
export class TreeService {

  constructor(private readonly http: HttpClient) { }

  /* /trees?user=10*/
  public getByUserID(userID: number): Observable<Tree[]> {
    return of((() => [
      {
        id: 0,
        title: 'Just tree',
        content: [
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
        ]
      }
    ])());

    // return this.http.get('/trees', {
    //   params: new HttpParams({fromObject: {user: userID.toString()}})
    // })
    // .map((page: Page<Tree[]>) => page.items);
  }
}
