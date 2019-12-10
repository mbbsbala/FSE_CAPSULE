export class Task {
    task:string;
    parentTask:string;
    priority:number;
    startDate:string;
    endDate:string;
    taskId:number;
    parentTaskId:number;
    editable:boolean;

    constructor(){
        this.task='';
        this.priority=15;
        this.startDate='';
        this.endDate='';
    }
}