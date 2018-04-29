import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Page} from '@app/models/page';

@Injectable()
export class CommentService {

  constructor(private readonly http: HttpClient) {}

  public getByTreeID(treeID: number): Observable<Comment[]> {
    return this.http.get('/comment', {
        params: new HttpParams({fromObject: {tree: treeID.toString()}})
    })
    .map((page: Page<Comment[]>) => page.items);
  }
}
