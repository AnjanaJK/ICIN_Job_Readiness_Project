import { Component } from '@angular/core';
import { AdminService } from '../service/admin.service';
import { UserLoginService } from '../service/user-login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  adminRole!: string | null;
  userRole!: string | null;
  adminName!: string | null;
  firstName!: string | null;
  lastName!: string | null;

  constructor(
    private adminService: AdminService,
    private userService: UserLoginService
  ) {
    // Fetch the userRole from the sessionStorage (or wherever you store it)
    this.adminRole = sessionStorage.getItem('adminRole');
    this.userRole = sessionStorage.getItem('userRole');
    this.adminName = sessionStorage.getItem('adminName');
    this.firstName = localStorage.getItem('FirstName');
    this.lastName = localStorage.getItem('LastName');
  }

  logout() {
    // Clear the user session data from sessionStorage
    this.adminService.clearSessionData();
    this.userService.clearSessionData();
    window.location.href = '/';
  }
}
