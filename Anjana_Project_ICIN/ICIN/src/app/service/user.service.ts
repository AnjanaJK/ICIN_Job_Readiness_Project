import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { ChequeBookRequestDTO } from '../class/cheque-book-request-dto';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private mainUrl = "http://localhost:8090";
  accountNo!: string | null;
  accountNum!: string | null;

  constructor(private http: HttpClient) { }

  MyAccountInfo(): Observable<any> {
    this.accountNo = sessionStorage.getItem("accountNo");
    return this.http.get<any>(`${this.mainUrl}/myInfo/${this.accountNo}`);
  }

  myRequests(): Observable<any> {
    this.accountNum = sessionStorage.getItem("accountNo");
    const endpoint = `${this.mainUrl}/myRequests/${this.accountNum}`;
    return this.http.get<any>(endpoint);
  }

  sendingRequest(requestBody: any): Observable<any> {

    this.accountNum = sessionStorage.getItem("accountNo");
    const endpoint = `${this.mainUrl}/chequeBookRequest/${this.accountNum}`;
    console.warn(endpoint, requestBody)
    console.warn("===========Going to backend================")
    return this.http.post(endpoint, requestBody);
  }

  sendTransaction(formData: any): Observable<any> {
    const endpoint = `${this.mainUrl}/processTransaction`;
    // console.warn(formData);
    return this.http.post(endpoint, formData);
  }

  myTransactions(): Observable<any> {
    this.accountNum = sessionStorage.getItem("accountNo");
    const endpoint = `${this.mainUrl}/myTransactions/${this.accountNum}`;
    return this.http.get<any>(endpoint);
  }


}
