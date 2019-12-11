import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from './model/task';

@Injectable({
  providedIn: 'root'
})
export class TaskmanagerService {

  constructor(private http: HttpClient) {
  }

  headers = new HttpHeaders({
    'Content-Type': 'application/json'});
  options = { headers: this.headers };

  getAll(): Observable<any> {
  // return this.http.get('http://localhost:9000/taskmanager/api/v1/task/view/all');

   return this.http.get('/assets/stubs/viewTask.json');
  }

  updateTask(task:Task): Observable<any>  {
    console.log(JSON.stringify(task));
    //return this.http.post('http://localhost:8080/taskmanager/api/v1/task/update', task , this.options);
    return this.http.get('/assets/stubs/successResponse.json');
  }

  addTask(task:Task): Observable<any>  {
    console.log(JSON.stringify(task));
    //return this.http.post('http://localhost:9000/taskmanager/api/v1/task/add', task , this.options);
    return this.http.get('/assets/stubs/successResponse.json');
  }

}
