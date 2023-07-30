import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminChequeBookRequestComponent } from './admin-cheque-book-request.component';

describe('AdminChequeBookRequestComponent', () => {
  let component: AdminChequeBookRequestComponent;
  let fixture: ComponentFixture<AdminChequeBookRequestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminChequeBookRequestComponent]
    });
    fixture = TestBed.createComponent(AdminChequeBookRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
