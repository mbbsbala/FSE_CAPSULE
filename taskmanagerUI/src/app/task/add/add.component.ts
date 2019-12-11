import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';
import { TaskmanagerService } from '../taskmanager.service';
import { Router } from '@angular/router';
import { FormControl } from '@angular/forms';
import { APIResponse } from '../model/APIResponse';
 

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  task: Task;
  value=15;
  apiresponse : APIResponse;
  constructor(private taskManagerService : TaskmanagerService, private router: Router) { }

  ngOnInit() {
    this.task = new Task();
    //this.task.priority=15;
  }

  addTask() {
    const startDate = this.task.startDate.toLocaleDateString();
    const endDate = this.task.endDate.toLocaleDateString();

    this.task.priority = this.value;
    this.task.startDate = startDate;
    this.task.endDate = endDate;
    this.taskManagerService.addTask(this.task).subscribe(data => {
      this.apiresponse = data;
    });
    this.router.navigate(['/view']);
  }

  resetTask(){
    this.task = new Task();
    this.value=15;
  }
}
