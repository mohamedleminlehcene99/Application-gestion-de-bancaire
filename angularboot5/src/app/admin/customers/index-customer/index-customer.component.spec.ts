import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexCustomerComponent } from './index-customer.component';

describe('IndexCustomerComponent', () => {
  let component: IndexCustomerComponent;
  let fixture: ComponentFixture<IndexCustomerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [IndexCustomerComponent]
    });
    fixture = TestBed.createComponent(IndexCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
