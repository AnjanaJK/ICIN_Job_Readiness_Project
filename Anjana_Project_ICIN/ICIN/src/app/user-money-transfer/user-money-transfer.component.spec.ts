import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserMoneyTransferComponent } from './user-money-transfer.component';

describe('UserMoneyTransferComponent', () => {
  let component: UserMoneyTransferComponent;
  let fixture: ComponentFixture<UserMoneyTransferComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserMoneyTransferComponent]
    });
    fixture = TestBed.createComponent(UserMoneyTransferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
