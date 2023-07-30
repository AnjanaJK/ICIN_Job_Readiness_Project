import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  response!: any[];
  myAccountNo!: string;

  constructor(private userService: UserService) {
    this.myAccountNo = String(sessionStorage.getItem('accountNo'));
  }

  ngOnInit() {
    this.showMyTransactions();
  }

  showMyTransactions() {
    this.userService.myTransactions().subscribe(
      (response: any) => {
        this.response = response;
      },
      (error) => {
        console.error("Error: ", error);
      }
    )
  }
}
