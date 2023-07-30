import { Component, OnInit } from '@angular/core';
import { Admin } from '../class/admin';
import { AdminService } from '../service/admin.service';
import { MessageService } from '../service/message.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  // Creating obj of User class (user.ts)
  admin: Admin = new Admin();
  loginMessage: string = '';
  isSuccessMessage: boolean = false;

  constructor(
    private adminService: AdminService,
    private messageService: MessageService
  ) { }

  ngOnInit(): void { }

  // MESSAGE ============
  getMessage(): string {
    return this.messageService.getMessage();
  }

  getMessageClass(): string {
    const message = this.messageService.getMessage();
    return message.toLowerCase().includes('success') ? 'success' : 'failure';
  }
  // ========================

  adminLogin() {
    // console.log(this.user);
    this.adminService.doLoginAdmin(this.admin).subscribe(
      (data: any) => {
        console.log(data);

        // Save the user ID in sessionStorage
        this.adminService.setSessionData(data);

        if (data.role === "Admin") {
          window.location.href = '/dashboardAdmin';
        }
        else {
          window.location.href = '/dashboardCustomer';
        }
        this.messageService.setMessage('Login Success!');

      },
      (error) => {
        this.messageService.setMessage('Login Failed. Please try again.');
      }
    );
  }

}
