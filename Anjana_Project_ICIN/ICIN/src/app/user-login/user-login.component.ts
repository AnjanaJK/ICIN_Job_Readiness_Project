import { Component, OnInit } from '@angular/core';
import { User } from '../class/user';
import { UserLoginService } from '../service/user-login.service';
import { MessageService } from '../service/message.service';
import { UserPass } from '../class/user-pass';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {


  // Creating obj of User class (user.ts)
  user: User = new User();
  userPass: UserPass = new UserPass();

  loginMessage: string = '';
  isSuccessMessage: boolean = false;

  constructor(
    private userService: UserLoginService,
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

  userLogin(accountNo: string, userPassword: string) {

    this.userService.doLoginUser(accountNo, userPassword).subscribe(
      (data: any) => {
        console.log("?")
        console.log(data);
        // console.log(this.user.accountNo);
        // console.log(this.user.userPassword);

        // Save the user ID in sessionStorage


        if (data.userDataArray[2] === "Customer") {
          console.log("isCust");
          if (data.userDataArray[5] == 1) {
            this.userService.setSessionData(data);
            this.messageService.setMessage('Login Success!');
            window.location.href = '/dashboardCustomer';
          }
          else {
            this.messageService.setMessage('Your Account is currently not active. Please Login 10 mins.');
          }

        }


      },
      (error) => {
        this.messageService.setMessage('Login Failed. Please try again.');
      }
    );
  }
}
