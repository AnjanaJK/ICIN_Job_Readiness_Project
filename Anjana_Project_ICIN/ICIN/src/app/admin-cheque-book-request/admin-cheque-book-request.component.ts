import { Component, OnInit } from '@angular/core';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-admin-cheque-book-request',
  templateUrl: './admin-cheque-book-request.component.html',
  styleUrls: ['./admin-cheque-book-request.component.css']
})
export class AdminChequeBookRequestComponent implements OnInit {

  data!: any[];

  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.displayAllRequests();
  }

  displayAllRequests() {
    this.adminService.getRequests().subscribe(
      (data) => {
        this.data = data;
      },
      (error) => {
        console.error('Error:', error);
      }
    )
  }

  onStatusChange(itemId: string, selectedValue: string) {
    // Convert the selectedValue to a number (0 or 1) if needed
    let intValue: number;
    if (selectedValue === "0") {
      intValue = 0; // Deactivated
    } else {
      intValue = 1; // Activated
    }
    console.log(intValue)

    // Update the status in the database using your data service
    this.adminService.updateRequestStatus(itemId, intValue).subscribe(
      (response) => {
        console.log('Status updated successfully!');
        window.location.reload();
      },
      (error) => {
        console.error('Failed to update status:', error);
      }
    );
  }


}
