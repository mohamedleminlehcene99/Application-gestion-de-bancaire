package com.lehcene.app_bancaire.controllers;

import com.lehcene.app_bancaire.dto.AccountDto;
import com.lehcene.app_bancaire.services.impl.AccountServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
@Tag(name = "Account")
public class AccountRestController {

    private final AccountServiceImpl accountService;

    //save

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.save(accountDto));
    }

    //findAll

    @GetMapping("/")
    public ResponseEntity<List<AccountDto>> findAll(){
        return ResponseEntity.ok(accountService.findAll());
    }

    //findById

    @GetMapping("/{account_id}")
    public ResponseEntity<AccountDto> findAccountById(@PathVariable("account_id") Integer account_id){
        return ResponseEntity.ok(accountService.findById(account_id));
    }

    //delete

    @DeleteMapping("/{account_id}")
    public ResponseEntity<Void> delete(@PathVariable("account_id") Integer account_id){
        accountService.delete(account_id);
        return ResponseEntity.accepted().build();
    }

}
