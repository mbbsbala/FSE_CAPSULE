import { Component, OnInit } from '@angular/core';
import { TaskmanagerService } from '../taskmanager.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  taskResponse: Array<any>;

  constructor(private taskManagerService: TaskmanagerService) { }

  ngOnInit() {
    this.taskManagerService.getAll().subscribe(data => {
      this.taskResponse = data;
    });
  }

}
