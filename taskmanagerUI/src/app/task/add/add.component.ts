import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';
import { TaskmanagerService } from '../taskmanager.service';
import { Router } from '@angular/router';
import { FormControl } from '@angular/forms';
 

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  task: Task;
  value=15;
  //date = new FormControl(new Date());
  constructor(private taskManagerService : TaskmanagerService, private router: Router) { }

  ngOnInit() {
    this.task = new Task();
    //this.task.priority=15;
  }

  addTask() {
    console.log("add task " , this.task);
    console.log(this.value);
    this.task.priority = this.value;
    this.taskManagerService.addTask(this.task).subscribe(data => {
      this.taskManagerService = data;
    });
    this.router.navigate(['/view']);
  }

  resetTask(){
    this.task = new Task();
  }
}
