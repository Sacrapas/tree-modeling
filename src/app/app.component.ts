import { Component } from '@angular/core';
import {UserService} from '@app/services/user.service';
import {TreeService} from '@app/services/tree.service';
import {CommentService} from '@app/services/comment.service';
import {User} from '@app/models/user';
import {Tree} from '@app/models/tree';
import {Comment} from '@app/models/comment';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent {

  public users: User[];
  public trees: Tree[];

  public user: User;
  public tree: Tree;
  public comments: Comment[];

  constructor(public readonly usersService:    UserService,
              public readonly treesService:    TreeService,
              public readonly commentsService: CommentService) {

    this.usersService.getAll().subscribe((users: User[]) => this.users = users);
  }

  public selectUser(userIndex: number): void {
    this.user = this.users[userIndex];
    this.treesService.getByUserID(this.user.id).subscribe((trees: Tree[]) => this.trees = trees);
  }

  public selectTree(treeIndex: number): void {
    this.tree = this.trees[treeIndex];
    console.log(this.tree);
    this.commentsService.getByTreeID(this.tree.id).subscribe((comments: Comment[]) => this.comments = comments);
  }
}
