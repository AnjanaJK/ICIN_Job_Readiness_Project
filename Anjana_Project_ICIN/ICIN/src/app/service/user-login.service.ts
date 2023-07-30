import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { User } from '../class/user';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {

  private signUpUrl = "http://localhost:8090/create";
  private loginUrl = "http://localhost:8090/loginUser";

  constructor(private http: HttpClient) { }

  public doSignUp(user: any, userLogin: any): Observable<any> {
    console.log(user);
    console.log(userLogin);
    const payload = { ...user, ...userLogin };
    return this.http.post(`${this.signUpUrl}`, payload);
  }

  public doLoginUser(accountNo: string, userPassword: string): Observable<any> {
    const loginRequest = { accountNo, userPassword };
    // console.log(loginRequest);
    return this.http.post(`${this.loginUrl}`, loginRequest);
  }

  public setSessionData(data: any): void {
    // Access userDataArray from the response data
    const userDataArray = data.userDataArray;
    sessionStorage.setItem('accountNo', userDataArray[0]);
    sessionStorage.setItem('userName', userDataArray[1]);
    sessionStorage.setItem('userRole', userDataArray[2]);
    localStorage.setItem('FirstName', userDataArray[3]);
    localStorage.setItem('LastName', userDataArray[4]);

  }

  public clearSessionData(): void {
    sessionStorage.removeItem('accountNo');
    sessionStorage.removeItem('userRole');
    sessionStorage.removeItem('userName');
    localStorage.removeItem('FirstName');
    localStorage.removeItem('LastName');
  }


}
