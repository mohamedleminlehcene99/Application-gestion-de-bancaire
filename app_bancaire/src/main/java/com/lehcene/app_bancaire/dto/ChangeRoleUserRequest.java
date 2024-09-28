package com.lehcene.app_bancaire.dto;

import lombok.Data;

@Data
public class ChangeRoleUserRequest {
    private Integer user_id;
    private Integer role_id;
}
