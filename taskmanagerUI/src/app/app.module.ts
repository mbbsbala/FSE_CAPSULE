import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewComponent } from './task/view/view.component';
import { AddComponent } from './task/add/add.component';
import { UpdateComponent } from './task/update/update.component';

@NgModule({
  declarations: [
    AppComponent,
    ViewComponent,
    AddComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
