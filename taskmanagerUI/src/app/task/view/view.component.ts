import { Component, OnInit, Output } from '@angular/core';
import { TaskmanagerService } from '../taskmanager.service';
import { ViewAllTaskResponse } from '../model/ViewAllTaskResponse';
import { Task } from '../model/task';
import { EventEmitter } from 'events';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  taskResponse: ViewAllTaskResponse;
  @Output() open = new EventEmitter();
  constructor(private taskManagerService: TaskmanagerService) { }

  ngOnInit() {
    this.taskManagerService.getAll().subscribe(data => {
      this.taskResponse = data;
    });
  }

  showUpdate(task: Task) {
    console.log('click', task);
  }

  endTask(task: Task) {
    console.log('click', task);
  }
}
