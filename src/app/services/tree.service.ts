import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Page} from '@app/models/page';
import {Tree} from '@app/models/tree';
import {HttpClient, HttpParams} from '@angular/common/http';
import 'rxjs/add/operator/map';


@Injectable()
export class TreeService {

  constructor(private readonly http: HttpClient) { }

  public getByUserID(userID: number): Observable<Tree[]> {
      return this.http.get('/tree', {
        params: new HttpParams({fromObject: {user: userID.toString()}})
      })
      .map((page: Page<Tree[]>) => page.items);
  }
}
