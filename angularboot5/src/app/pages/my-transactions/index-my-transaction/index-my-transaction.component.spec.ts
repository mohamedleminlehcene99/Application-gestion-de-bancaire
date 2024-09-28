import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexMyTransactionComponent } from './index-my-transaction.component';

describe('IndexMyTransactionComponent', () => {
  let component: IndexMyTransactionComponent;
  let fixture: ComponentFixture<IndexMyTransactionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [IndexMyTransactionComponent]
    });
    fixture = TestBed.createComponent(IndexMyTransactionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
