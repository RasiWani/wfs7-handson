import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { XyzComponent } from './xyz/xyz.component';
import { ProfileDisplayComponent } from './profile-display/profile-display.component';
import { DisplayEmployeeComponent } from './display-employee/display-employee.component';

@NgModule({
  declarations: [
    AppComponent,
    XyzComponent,
    ProfileDisplayComponent,
    DisplayEmployeeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
