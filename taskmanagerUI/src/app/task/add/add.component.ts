import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';
import { TaskmanagerService } from '../taskmanager.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  task: Task;
  constructor(private taskManagerService : TaskmanagerService, private router: Router) { }

  ngOnInit() {
  }

  addTask(task: Task) {
    this.taskManagerService.addTask(task).subscribe(data => {
      this.taskManagerService = data;
    });
    this.router.navigate(['/view']);
  }
}
