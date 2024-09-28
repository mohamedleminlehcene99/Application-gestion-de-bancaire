package com.lehcene.app_bancaire.repositories;

import com.lehcene.app_bancaire.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByIbn(String ibnCode);

    Optional<Account> findByUserId(Integer id);
}
