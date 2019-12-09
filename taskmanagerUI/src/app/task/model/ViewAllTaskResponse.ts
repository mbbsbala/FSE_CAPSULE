import { APIResponse } from './APIResponse';
import { Task } from './task';

export class ViewAllTaskResponse extends APIResponse {
    taskList:Array<Task>;
}