import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private message: string = '';
  // private messageSubject: BehaviorSubject<any> = new BehaviorSubject<any>(null);

  setMessage(message: string) {
    this.message = message;
  }

  getMessage(): string {
    return this.message;
  }

  // setMessage2(message: any): void {
  //   this.messageSubject.next(message);
  // }

  // // Get the message from the service
  // getMessage2(): any {
  //   return this.messageSubject.getValue();
  // }
}
