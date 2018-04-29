import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {User} from '@app/models/user';
import {Page} from '@app/models/page';
import 'rxjs/add/operator/map';


@Injectable()
export class UserService {

  constructor(private readonly http: HttpClient) { }

    /* /users */
    public getAll(): Observable<User[]> {
    return this.http.get('/users').map((page: Page<User[]>) => page.items);
  }

}
