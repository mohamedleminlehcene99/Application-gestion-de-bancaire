package com.lehcene.app_bancaire.services.impl;

import com.lehcene.app_bancaire.dto.AddressDto;
import com.lehcene.app_bancaire.models.Address;
import com.lehcene.app_bancaire.repositories.AddressRepository;
import com.lehcene.app_bancaire.services.AddressService;
import com.lehcene.app_bancaire.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final ObjectsValidator<AddressDto> validator;
    private final AddressRepository addressRepository;

    @Override
    public Integer save(AddressDto addressDto) {

        validator.validate(addressDto);

        Address address = AddressDto.toEntity(addressDto);

        return addressRepository.save(address).getId();
    }

    @Override
    public List<AddressDto> findAll() {
        return addressRepository.findAll().stream().map(AddressDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(Integer id) {
        return addressRepository.findById(id).map(AddressDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("Not found user with this provided ID"));
    }

    @Override
    public void delete(Integer id) {
                addressRepository.deleteById(id);
    }
}
