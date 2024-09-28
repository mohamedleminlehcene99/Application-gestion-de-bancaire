package com.lehcene.app_bancaire.dto;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
