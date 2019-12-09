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
        this.parentTask='';
        this.priority=0;
        this.startDate='';
        this.endDate='';
        this.taskId=0;
        this.parentTaskId=0;
        this.editable=true;        
    }
}