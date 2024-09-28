import { TestBed } from '@angular/core/testing';

import { StatusAccountUserService } from './status-account-user.service';

describe('StatusAccountUserService', () => {
  let service: StatusAccountUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StatusAccountUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
