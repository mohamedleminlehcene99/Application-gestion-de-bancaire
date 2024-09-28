package com.lehcene.app_bancaire.services;

import com.lehcene.app_bancaire.dto.TransactionDto;

import java.util.List;

public interface TransactionService extends AbstractService<TransactionDto> {

    List<TransactionDto> getAllTransactionsByUserId(Integer user_id);
}
