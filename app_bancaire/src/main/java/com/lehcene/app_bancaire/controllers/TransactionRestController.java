package com.lehcene.app_bancaire.controllers;

import com.lehcene.app_bancaire.dto.TransactionDto;
import com.lehcene.app_bancaire.services.impl.TransactionServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
@Tag(name = "Transaction")
public class TransactionRestController {

    private final TransactionServiceImpl transactionService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody TransactionDto transactionDto){
        return ResponseEntity.ok(transactionService.save(transactionDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<TransactionDto>> findAll(){
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{transaction_id}")
    public ResponseEntity<TransactionDto> findTransactionById(@PathVariable("transaction_id") Integer transaction_id){
            return ResponseEntity.ok(transactionService.findById(transaction_id));
    }

    @DeleteMapping("{transaction_id}")
    public ResponseEntity<Void> delete(@PathVariable("transaction_id") Integer transaction_id){
        transactionService.delete(transaction_id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<TransactionDto>> findAllTransactionByUserId(@PathVariable("user_id") Integer user_id){
     return ResponseEntity.ok(transactionService.getAllTransactionsByUserId(user_id));
    }


}
