import { TestBed } from '@angular/core/testing';

import { BackToLoginRegisterGuardService } from './back-to-login-register-guard.service';

describe('BackToLoginRegisterGuardService', () => {
  let service: BackToLoginRegisterGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BackToLoginRegisterGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
