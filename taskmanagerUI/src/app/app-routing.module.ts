import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddComponent } from './task/add/add.component';
import { UpdateComponent } from './task/update/update.component';
import { ViewComponent } from './task/view/view.component';


const routes: Routes = [
  {path: 'add' , pathMatch: 'full', component: AddComponent},
  {path: 'update' , pathMatch: 'full', component: UpdateComponent},
  {path: 'view' , pathMatch: 'full', component: ViewComponent},
  {path: '', pathMatch: 'full', redirectTo: 'view'}  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

}
