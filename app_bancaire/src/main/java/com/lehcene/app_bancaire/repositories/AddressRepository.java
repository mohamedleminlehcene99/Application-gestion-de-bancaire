package com.lehcene.app_bancaire.repositories;

import com.lehcene.app_bancaire.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
