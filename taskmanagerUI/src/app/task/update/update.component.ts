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
    this.task.startDate = this.parsePickerDate(this.task.startDate);
    this.task.endDate = this.parsePickerDate(this.task.endDate);
  }

  ngOnInit() {
    
  }

  updateTask() {
    console.log("updated task " , this.task);
    console.log(this.value);

    const startDate = this.task.startDate.toLocaleDateString();
    const endDate = this.task.endDate.toLocaleDateString();

    this.task.priority = this.value;
    this.task.startDate = startDate;
    this.task.endDate = endDate;
    this.taskManagerService.updateTask(this.task).subscribe(data => {
      this.taskManagerService = data;
    });
    this.router.navigate(['/view']);
  }

  parsePickerDate(strDate: String): Date {
    const str = strDate.split('/');

    const date = Number(str[0]);
    const month = Number(str[1]) - 1;
    const year = Number(str[2]);

    return new Date(year, month, date);
  }
}
