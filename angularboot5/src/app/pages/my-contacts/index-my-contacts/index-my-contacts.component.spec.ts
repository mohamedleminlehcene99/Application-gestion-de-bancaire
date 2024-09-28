import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexMyContactsComponent } from './index-my-contacts.component';

describe('IndexMyContactsComponent', () => {
  let component: IndexMyContactsComponent;
  let fixture: ComponentFixture<IndexMyContactsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [IndexMyContactsComponent]
    });
    fixture = TestBed.createComponent(IndexMyContactsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
