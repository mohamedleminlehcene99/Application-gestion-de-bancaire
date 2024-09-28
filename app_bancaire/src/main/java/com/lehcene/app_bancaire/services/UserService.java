package com.lehcene.app_bancaire.services;

import com.lehcene.app_bancaire.dto.*;

public interface UserService extends AbstractService<UserDto> {

    int valaidateAccountUserById(Integer id);
    int inValidateAccountUserById(Integer id);
    AuthenticationResponse authentication(AuthenticationRequest request);
    AuthenticationResponse registration(RegistrationRequest request, boolean isAdmin);
    void changerRoleUser(ChangeRoleUserRequest changeRoleUserRequest);
}


