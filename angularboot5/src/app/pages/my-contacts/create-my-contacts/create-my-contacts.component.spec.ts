import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMyContactsComponent } from './create-my-contacts.component';

describe('CreateMyContactsComponent', () => {
  let component: CreateMyContactsComponent;
  let fixture: ComponentFixture<CreateMyContactsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateMyContactsComponent]
    });
    fixture = TestBed.createComponent(CreateMyContactsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
