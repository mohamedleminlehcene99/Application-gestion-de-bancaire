import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContentDashbordComponent } from './content-dashbord.component';

describe('ContentDashbordComponent', () => {
  let component: ContentDashbordComponent;
  let fixture: ComponentFixture<ContentDashbordComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContentDashbordComponent]
    });
    fixture = TestBed.createComponent(ContentDashbordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
