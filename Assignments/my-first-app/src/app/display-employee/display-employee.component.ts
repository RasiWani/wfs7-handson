import { Component, OnInit } from '@angular/core';
import { EMP_ARRAY } from '../mock';

@Component({
  selector: 'app-display-employee',
  templateUrl: './display-employee.component.html',
  styleUrls: ['./display-employee.component.css']
})
export class DisplayEmployeeComponent
{
  employee : any = undefined;
  employeeArray : any = EMP_ARRAY;
  constructor() {
  this.employeeArray = EMP_ARRAY;
  }
}
