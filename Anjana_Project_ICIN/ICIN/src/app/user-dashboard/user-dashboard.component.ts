import { Component } from '@angular/core';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent {

  firstName!: string | null;
  lastName!: string | null;

  constructor() {
    this.firstName = localStorage.getItem('FirstName');
    this.lastName = localStorage.getItem('LastName');
  }
}
