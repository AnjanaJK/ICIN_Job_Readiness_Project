import { Injectable } from '@angular/core';
import { Admin } from '../class/admin';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/internal/operators/catchError';
import { throwError } from 'rxjs/internal/observable/throwError';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private mainUrl = "http://localhost:8090";

  private loginUrl = "http://localhost:8090/loginAdmin";
  private getAllUrl = "http://localhost:8090/showAll";
  private getAllRequestsUrl = "http://localhost:8090/showAllRequests";


  constructor(private http: HttpClient) { }

  public setSessionData(data: any): void {
    sessionStorage.setItem('adminId', data.adminId);
    sessionStorage.setItem('adminName', data.adminUsername);
    sessionStorage.setItem('adminRole', data.role);
  }

  public clearSessionData(): void {
    sessionStorage.removeItem('adminId');
    sessionStorage.removeItem('adminName');
    sessionStorage.removeItem('adminRole');
  }


  doLoginAdmin(admin: Admin): Observable<object> {
    return this.http.post(`${this.loginUrl}`, admin);
  }

  getUsers(): Observable<any> {
    return this.http.get<any>(`${this.getAllUrl}`);
  }

  updateStatus(itemId: string, statusValue: number): Observable<any> {
    // Replace 'your-endpoint' with the actual endpoint in your Spring Boot backend
    const endpoint = `${this.mainUrl}/updateStatus/${itemId}`;

    // Create the request body with the updated status value
    // const requestBody = { status: statusValue };

    // Make a PUT request to update the status in the backend
    return this.http.put(endpoint, statusValue);
  }

  getRequests(): Observable<any> {
    return this.http.get<any>(`${this.getAllRequestsUrl}`);
  }
  updateRequestStatus(itemId: string, statusValue: number): Observable<any> {
    // Replace 'your-endpoint' with the actual endpoint in your Spring Boot backend
    const endpoint = `${this.mainUrl}/updateRequestStatus/${itemId}`;

    // Create the request body with the updated status value
    // const requestBody = { status: statusValue };

    // Make a PUT request to update the status in the backend
    return this.http.put(endpoint, statusValue);
  }

}
