import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskmanagerService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
   // return this.http.get('http://localhost:9000/taskmanager/api/v1/task/view/all');

   return this.http.get('/assets/stubs/viewTask.json')
  }
}
