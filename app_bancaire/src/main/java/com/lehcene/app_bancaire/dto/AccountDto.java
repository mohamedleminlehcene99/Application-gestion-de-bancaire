package com.lehcene.app_bancaire.dto;

import com.lehcene.app_bancaire.models.Account;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {

    private Integer id;

    private String ibn;
    private Integer userId;

    public static AccountDto fromEntity(Account account){
        return AccountDto.builder()
                .id(account.getId())
                .ibn(account.getIbn())
                .userId(account.getUser().getId())
                .build();
    }

    public static Account toEntity(AccountDto accountDto){
        return Account.builder()
                .id(accountDto.getId())
                .ibn(accountDto.getIbn())
                .user(UserDto.toEntity(UserDto.builder().id(accountDto.getUserId()).build()))
                .build();
    }
}

