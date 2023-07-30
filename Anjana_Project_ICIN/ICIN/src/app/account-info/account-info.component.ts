import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-account-info',
  templateUrl: './account-info.component.html',
  styleUrls: ['./account-info.component.css']
})
export class AccountInfoComponent implements OnInit {

  data!: any[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.displayAccountInfo();
  }

  displayAccountInfo() {
    this.userService.MyAccountInfo().subscribe(
      (data) => {
        this.data = data;
      },
      (error) => {
        console.error('Error:', error);
      }
    )
  }

}
