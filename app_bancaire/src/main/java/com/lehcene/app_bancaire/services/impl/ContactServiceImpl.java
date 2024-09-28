package com.lehcene.app_bancaire.services.impl;

import com.lehcene.app_bancaire.dto.ContactDto;
import com.lehcene.app_bancaire.models.Contact;
import com.lehcene.app_bancaire.repositories.ContactRepository;
import com.lehcene.app_bancaire.services.ContactService;
import com.lehcene.app_bancaire.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ObjectsValidator<ContactDto> validator;
    private final ContactRepository contactRepository;

    @Override
    public Integer save(ContactDto contactDto) {

        validator.validate(contactDto);

        Contact contact = ContactDto.toEntity(contactDto);

        return contactRepository.save(contact).getId();
    }

    @Override
    public List<ContactDto> findAll() {
        return contactRepository.findAll().stream().map(ContactDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public ContactDto findById(Integer id) {
        return contactRepository.findById(id).map(ContactDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("Not found user with this provided ID"));
    }

    @Override
    public void delete(Integer id) {
            contactRepository.deleteById(id);
    }

    @Override
    public List<ContactDto> getAllContactsByUserId(Integer user_id) {
        return contactRepository.findAllByUserId(user_id).stream().map(ContactDto::fromEntity).collect(Collectors.toList());
    }

}

