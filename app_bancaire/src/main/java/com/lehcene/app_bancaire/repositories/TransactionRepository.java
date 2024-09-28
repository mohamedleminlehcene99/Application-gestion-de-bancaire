package com.lehcene.app_bancaire.repositories;

import com.lehcene.app_bancaire.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    List<Transaction> findAllByUserId(Integer user_id);
}
