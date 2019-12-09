import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';
import { Router, ActivatedRoute, NavigationStart } from '@angular/router';
import { Observable } from 'rxjs';
import { filter } from 'minimatch';
import { Data } from 'src/app/Data';
import { TaskmanagerService } from '../taskmanager.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  task: Task;
  constructor(private taskManagerService : TaskmanagerService, private router: Router) { }

  ngOnInit() {
  }

  addTask(task: Task) {
    this.taskManagerService.updateTask(task).subscribe(data => {
      this.taskManagerService = data;
    });
    this.router.navigate(['/view']);
  }

}
