import { Component, OnInit } from '@angular/core';
import { AdminService } from '../service/admin.service';
import { MessageService } from '../service/message.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  public adminId!: number;
  public adminName!: string;
  public adminRole!: string;

  constructor(private adminService: AdminService, private messageService: MessageService) { }

  data!: any[];


  ngOnInit(): void {
    this.displayAllUsers();
    // Fetch the accountNo from the sessionStorage
    this.adminId = Number(sessionStorage.getItem('adminId'));
    this.adminName = String(sessionStorage.getItem('adminName'));
    this.adminRole = String(sessionStorage.getItem('adminRole'));
  }

  // MESSAGE ============
  getMessage(): string {
    return this.messageService.getMessage();
  }

  getMessageClass(): string {
    const message = this.messageService.getMessage();
    return message.toLowerCase().includes('success') ? 'success' : 'failure';
  }
  // ========================

  // Idt this is needed as it is already in the header.ts file
  logout() {
    // Clear the user session data from sessionStorage
    this.adminService.clearSessionData();
    window.location.href = '';
  }

  displayAllUsers() {
    this.adminService.getUsers().subscribe(
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
    this.adminService.updateStatus(itemId, intValue).subscribe(
      (response) => {
        console.log('Status updated successfully!');
        // Refresh the page after successful update
        window.location.reload();
      },
      (error) => {
        console.error('Failed to update status:', error);
        // Display error message on the page
        this.messageService.setMessage('Something went wrong, could not update');
      }
    );
  }
}
