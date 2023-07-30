import { Component, OnInit } from '@angular/core';
import { User } from '../class/user';
import { UserPass } from '../class/user-pass';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageService } from '../service/message.service';
import { UserLoginService } from '../service/user-login.service';
import { SignUpResponse } from '../class/response.interface';

@Component({
  selector: 'app-new-account',
  templateUrl: './new-account.component.html',
  styleUrls: ['./new-account.component.css']
})
export class NewAccountComponent implements OnInit {
  user: User = new User();
  userLogin: UserPass = new UserPass();
  loginMessage: string = '';
  isSuccessMessage: boolean = false;
  msg: any;
  // New properties for the timer
  timerValue: number = 20;
  timerActive: boolean = false;

  constructor(
    private userLoginService: UserLoginService,
    private messageService: MessageService,
    private router: Router, // Inject the Router
    private activatedRoute: ActivatedRoute
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
  // ======================


  userCreate() {
    // console.log('entered');
    if (this.validateForm()) {
      console.log(this.userLogin.trnPassword);
      if (this.userLogin.trnPassword === this.userLogin.userPassword) {
        this.messageService.setMessage("Account creation Failed! Transaction Password should be different from the Account Password.");
        return;
      }

      console.log('done validating');
      console.log('Form invalid');
      console.log('Form is valid. Proceeding with signup...');
      this.userLoginService.doSignUp(this.user, this.userLogin).subscribe(
        (response: SignUpResponse) => {
          // console.log(data);
          console.log('Account number:', response.accountNumber);
          this.messageService.setMessage(
            `Account created successfully! Your Account no. is ${response.accountNumber}. Please note this down for future logins. Page will redirect in 20 seconds.`
          );
          // this.messageService.setMessage('Signup Success!');
          console.log("Password = " + this.userLogin.userPassword)

          this.timerActive = true; // Activate the timer
          this.startTimer(); // Start the 20-second timer

          setTimeout(() => {
            this.router.navigate(['/user-login']); // Redirect to the login page after 20 seconds
          }, 20000); // 20 seconds delay using milliseconds
        }, (error) => {
          console.error(error); // Log the error to the console for debugging
          this.messageService.setMessage('Signup FAILED!');
        }
      )
    } else {
      console.log(' validating FALSE');
      this.msg = 'All fields are required!'; // Set validation error message
    }
  }

  // Validate the form fields
  validateForm(): boolean {
    if (
      !this.user.userFirstName ||
      !this.user.userLastName ||
      !this.user.userEmail ||
      !this.user.userPhoneNo ||
      !this.user.userAddress ||
      !this.user.userLocation ||
      !this.userLogin.userPassword ||
      !this.userLogin.trnPassword
    ) {
      console.log(this.user);
      console.log("false");
      return false; // Return false if any field is empty
    }
    console.log('true')
    return true; // Return true if all fields are filled
  }

  startTimer() {
    const interval = setInterval(() => {
      this.timerValue -= 1; // Decrement the timer value by 1 second
      if (this.timerValue <= 0) {
        clearInterval(interval); // Stop the timer when it reaches 0
        this.timerActive = false; // Deactivate the timer
      }
    }, 1000); // 1000 milliseconds = 1 second
  }

}
