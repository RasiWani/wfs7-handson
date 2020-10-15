import { Component, OnInit } from '@angular/core';
import { USER } from '../mock'
@Component({
  selector: 'app-profile-display',
  templateUrl: './profile-display.component.html',
  styleUrls: ['./profile-display.component.css']
})
export class ProfileDisplayComponent  {
  profile : any = undefined;
  salary = 2500;
  constructor() {
    this.profile = USER;
  }
}
