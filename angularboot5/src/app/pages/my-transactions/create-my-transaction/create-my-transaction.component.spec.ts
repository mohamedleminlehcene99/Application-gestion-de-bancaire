import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMyTransactionComponent } from './create-my-transaction.component';

describe('CreateMyTransactionComponent', () => {
  let component: CreateMyTransactionComponent;
  let fixture: ComponentFixture<CreateMyTransactionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateMyTransactionComponent]
    });
    fixture = TestBed.createComponent(CreateMyTransactionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
