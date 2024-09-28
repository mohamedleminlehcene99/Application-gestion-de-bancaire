package com.lehcene.app_bancaire.services.impl;

import com.lehcene.app_bancaire.dto.AccountDto;
import com.lehcene.app_bancaire.models.Account;
import com.lehcene.app_bancaire.repositories.AccountRepository;
import com.lehcene.app_bancaire.services.AccountService;
import com.lehcene.app_bancaire.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final ObjectsValidator<AccountDto> validator;
    private final AccountRepository accountRepository;

    @Override
    public Integer save(AccountDto accountDto) {

        validator.validate(accountDto);

        Account account = AccountDto.toEntity(accountDto);

        if (accountDto.getIbn()==null){
            String ibn = this.generateRandomIbn();
            account.setIbn(ibn);
        }

        return  accountRepository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {
        return accountRepository.findAll().stream().map(AccountDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(Integer id) {
        return accountRepository.findById(id).map(AccountDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("Not found user with this provided ID"));
    }

    @Override
    public void delete(Integer id) {
            accountRepository.deleteById(id);
    }

    private String generateRandomIbn(){

        //generate IBN

        String ibnCode = Iban.random(CountryCode.DE).toFormattedString();

        //check if ibn already exist

        boolean ibnExist = accountRepository.findByIbn(ibnCode).isPresent();

        if (ibnExist){
            generateRandomIbn();
        }

        return ibnCode;

    }
}
