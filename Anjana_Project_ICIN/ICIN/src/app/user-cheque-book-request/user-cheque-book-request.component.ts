import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { ChequeBookRequestDTO } from '../class/cheque-book-request-dto';
import { MessageService } from '../service/message.service';

@Component({
  selector: 'app-user-cheque-book-request',
  templateUrl: './user-cheque-book-request.component.html',
  styleUrls: ['./user-cheque-book-request.component.css']
})
export class UserChequeBookRequestComponent implements OnInit {

  response!: any[];
  myAccountNo!: string;

  accountType: string = 'Savings';
  desc!: string;

  constructor(private userService: UserService, private messageService: MessageService) {
    this.myAccountNo = String(sessionStorage.getItem('accountNo'));
  }

  ngOnInit() {
    this.showMyRequests();
  }

  // MESSAGE ============
  getMessage(): string {
    return this.messageService.getMessage();
  }

  getMessageClass(): string {
    const message = this.messageService.getMessage();
    return message.toLowerCase().includes('success') ? 'success' : 'failure';
  }
  // ======================

  showMyRequests() {
    this.userService.myRequests().subscribe(
      (response: any) => {
        this.response = response;
      },
      (error) => {
        console.error("Error: ", error);
      }
    )
  }

  sendRequest() {
    if (!this.desc) {
      this.messageService.setMessage('All fields needed!');
    }
    else {
      const requestBody = {
        accountType: this.accountType,
        description: this.desc
      };
      // console.warn(requestBody);
      // console.warn(requestBody.accountNo)
      this.userService.sendingRequest(requestBody).subscribe(
        (response) => {
          console.log('Request sent successfully!', response);
          this.messageService.setMessage('Request sent successfully!!');
          // Refresh the page after successful update
          window.location.reload();
        },
        (error) => {
          console.error("Error: ", error);
          this.messageService.setMessage('Request creation FAILED!');
        }
      )
    }

  }
}
