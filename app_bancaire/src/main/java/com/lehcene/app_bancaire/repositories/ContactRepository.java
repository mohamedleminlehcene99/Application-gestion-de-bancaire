package com.lehcene.app_bancaire.repositories;

import com.lehcene.app_bancaire.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findAllByUserId(Integer user_id);
}
