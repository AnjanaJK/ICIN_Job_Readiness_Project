import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserChequeBookRequestComponent } from './user-cheque-book-request.component';

describe('UserChequeBookRequestComponent', () => {
  let component: UserChequeBookRequestComponent;
  let fixture: ComponentFixture<UserChequeBookRequestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserChequeBookRequestComponent]
    });
    fixture = TestBed.createComponent(UserChequeBookRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
