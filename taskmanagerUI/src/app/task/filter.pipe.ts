import { Pipe, PipeTransform } from '@angular/core';
import { Task } from './model/task';
@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {
  transform(items: Task[], searchText: string, searchParent: string , priorityFrom: number ,
     priorityTo: number, startDate: Date ,endDate : Date): Task[] {
    if(!items) return [];
    if(!searchText && !searchParent && !priorityFrom && !priorityTo && !startDate && !endDate) return items;

    if(searchText) {
      searchText = searchText.toLowerCase();
      items = items.filter( it => {
          return it.task.toLowerCase().includes(searchText);
          });
    }
    
    if(searchParent) {
      searchParent = searchParent.toLowerCase();
      items = items.filter( it => {
        if(it.parentTask) {
          return it.parentTask.toLowerCase().includes(searchParent);
        }});
    }

    if(priorityFrom) {
      items = items.filter( it => {
          return it.priority >= priorityFrom;
      });
    }

    if(priorityTo) {
      items = items.filter( it => {
          return it.priority <= priorityTo;
      });
    }

    if(startDate) {
      items = items.filter( it => {
          let convertedPickerDate: Date = this.parsePickerDate(startDate);
          let convertedStartDate: Date = this.parseStrToDate(it.startDate);
          return convertedStartDate >= convertedPickerDate;
      });
    }

    if(endDate) {
      items = items.filter( it => {
          let convertedPickerDate: Date = this.parsePickerDate(endDate);
          let convertedEndDate: Date = this.parseStrToDate(it.endDate);
          return convertedEndDate <= convertedPickerDate;
      });
    }

    return items;

  }

  parseStrToDate(strDate: String): Date {
    const str = strDate.split('/');

    const month = Number(str[1]) - 1;
    const year = Number(str[2]);
    const date = Number(str[0]);

    return new Date(year, month, date);
  }

  parsePickerDate(strDate: Date): Date {
    const str = strDate.toLocaleString().split('-');

    const month = Number(str[1]) - 1;
    const year = Number(str[0]);
    const date = Number(str[2]);

    return new Date(year, month, date);
  }
}