import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { TaskmanagerService } from '../taskmanager.service';
import { ViewAllTaskResponse } from '../model/ViewAllTaskResponse';
import { Task } from '../model/task';
import { Router } from '@angular/router';
import { Data } from 'src/app/Data';
import { APIResponse } from '../model/APIResponse';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  taskResponse: ViewAllTaskResponse;
  apiresponse : APIResponse;
  endTaskDetail: Task;
  constructor(private taskManagerService: TaskmanagerService, private router: Router,  private data: Data) { }

  ngOnInit() {
    this.taskManagerService.getAll().subscribe(data => {
      this.taskResponse = data;
    });
  }

  showUpdate(task: Task) {
    console.log('click', task);
    this.data.storage = task;
    this.router.navigate(['/update']);
  }

  endTask(task: Task) {
    this.endTaskDetail = new Task;
    this.endTaskDetail = task;
    this.endTaskDetail.endDate = "01/12/2019";
    this.endTaskDetail.editable = false;
    this.taskManagerService.updateTask(this.endTaskDetail).subscribe(data => {
      this.taskManagerService = data;
    });
    this.router.navigate(['/view']);
  }
}
