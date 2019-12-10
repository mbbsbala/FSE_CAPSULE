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
  value: number;
  constructor(private taskManagerService : TaskmanagerService, private data: Data, private router: Router) { 
    console.log("data ", JSON.stringify(data.storage));
    this.task = this.data.storage;
    this.value = this.task.priority;
  }

  ngOnInit() {
    
  }

  updateTask() {
    console.log("updated task ", this.task);
    //this.task = new Task;
    // this.task.task = updateTaskForm.task;
    // if(updateTaskForm.parentTask != null) {
    //   this.task.parentTask = updateTaskForm.parentTask;
    // }
    // this.task.startDate = updateTaskForm.startDate;
    // this.task.endDate = updateTaskForm.endDate;
    // this.task.priority = updateTaskForm.priority;
    this.taskManagerService.updateTask(this.task).subscribe(data => {
      this.taskManagerService = data;
    });
    this.router.navigate(['/view']);
  }

  onClickSubmit(formData) {
    alert('Your task is : ' + formData.task);
 }

}
