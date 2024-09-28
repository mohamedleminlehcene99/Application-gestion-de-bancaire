package com.lehcene.app_bancaire.services;

import com.lehcene.app_bancaire.dto.ContactDto;

import java.util.List;

public interface ContactService extends AbstractService<ContactDto>{

    List<ContactDto> getAllContactsByUserId(Integer user_id);

}
