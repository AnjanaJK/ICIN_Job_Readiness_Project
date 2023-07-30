import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { MessageService } from '../service/message.service';

@Component({
  selector: 'app-user-money-transfer',
  templateUrl: './user-money-transfer.component.html',
  styleUrls: ['./user-money-transfer.component.css']
})
export class UserMoneyTransferComponent {
  formData = {
    receiverAccountNo: '',
    trnPassword: '',
    trnAmount: 0,
    description: ''
  };

  constructor(private userService: UserService, private messageService: MessageService) { }

  // MESSAGE ============
  getMessage(): string {
    return this.messageService.getMessage();
  }

  getMessageClass(): string {
    const message = this.messageService.getMessage();
    return message.toLowerCase().includes('success') ? 'success' : 'failure';
  }
  // ======================

  submitTrnForm() {
    // Retrieve logged-in user's account number from session storage (change 'loggedInUserAccountNo' accordingly)
    const senderAccountNo = sessionStorage.getItem('accountNo');

    // Include senderAccountNo in the formData
    const formDataWithSender = {
      ...this.formData,
      senderAccountNo
    };

    // console.warn(formDataWithSender);
    // Call API service to send the form data to the backend
    this.userService.sendTransaction(formDataWithSender).subscribe(
      (response) => {
        // Handle success response
        console.warn(response);
        this.messageService.setMessage('Transaction successful');
      },
      (error) => {
        // Handle error response
        console.warn(error);
        if (error.status == 401) {
          console.warn("401")
          this.messageService.setMessage("Transaction failed: Password does not match");
        }
        if (error.status == 404) {
          console.error("404")
          this.messageService.setMessage('Transaction failed: User not found');
        }
        if (error.status == 403) {
          console.warn("403")
          this.messageService.setMessage('Transaction failed: Insufficient funds in your A/C');
        }

      }
    );
  }
}
