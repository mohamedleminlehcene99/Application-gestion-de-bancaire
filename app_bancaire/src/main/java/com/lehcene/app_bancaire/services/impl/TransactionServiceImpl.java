package com.lehcene.app_bancaire.services.impl;

import com.lehcene.app_bancaire.dto.TransactionDto;
import com.lehcene.app_bancaire.enums.TransactionType;
import com.lehcene.app_bancaire.models.Transaction;
import com.lehcene.app_bancaire.repositories.TransactionRepository;
import com.lehcene.app_bancaire.services.TransactionService;
import com.lehcene.app_bancaire.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ObjectsValidator<TransactionDto> validator;

    @Override
    public Integer save(TransactionDto transactionDto) {

        validator.validate(transactionDto);

        Transaction transaction = TransactionDto.toEntity(transactionDto);

        BigDecimal transactionMultipier = BigDecimal.valueOf(getTransactionMultiplier(transaction.getTransactionType()));
        BigDecimal amount = transaction.getAmount().multiply(transactionMultipier);

        transaction.setAmount(amount);

        return transactionRepository.save(transaction).getId();
    }

    @Override
    public List<TransactionDto> findAll() {
        return transactionRepository.findAll().stream().map(TransactionDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public TransactionDto findById(Integer id) {
        return transactionRepository.findById(id).map(TransactionDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("Not found user with this provided ID"));
    }

    @Override
    public void delete(Integer id) {
            transactionRepository.deleteById(id);
    }

    private int getTransactionMultiplier(TransactionType transactionType){
        return TransactionType.TRANSFERT == transactionType ? -1 : 1;
    }

    @Override
    public List<TransactionDto> getAllTransactionsByUserId(Integer user_id) {
        return transactionRepository.findAllByUserId(user_id).stream().map(TransactionDto::fromEntity).collect(Collectors.toList());
    }
}
