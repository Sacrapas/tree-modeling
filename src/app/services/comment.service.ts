import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Page} from '@app/models/page';
import {Comment} from '@app/models/comment';
import 'rxjs/add/operator/map';
import {of} from 'rxjs/observable/of';

@Injectable()
export class CommentService {

  constructor(private readonly http: HttpClient) {}

  /* /comments?tree=10 */
  public getByTreeID(treeID: number): Observable<Comment[]> {
    return of((() => [
      {
        content: 'Мне нравится',
        author_name: 'Вася'
      },
      {
        content: 'Мне не нравится',
        author_name: 'Петя'
      }
    ])());
    // return this.http.get('/comments', {
    //     params: new HttpParams({fromObject: {tree: treeID.toString()}})
    // })
    // .map((page: Page<Comment[]>) => page.items);
  }
}
