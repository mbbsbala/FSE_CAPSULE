import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewComponent } from './task/view/view.component';
import { AddComponent } from './task/add/add.component';
import { UpdateComponent } from './task/update/update.component';

import { HttpClientModule } from '@angular/common/http';
import { TaskmanagerService } from './task/taskmanager.service';

@NgModule({
  declarations: [
    AppComponent,
    ViewComponent,
    AddComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [TaskmanagerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
