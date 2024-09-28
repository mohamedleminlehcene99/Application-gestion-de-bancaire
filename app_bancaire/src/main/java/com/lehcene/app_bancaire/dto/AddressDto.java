package com.lehcene.app_bancaire.dto;

import com.lehcene.app_bancaire.models.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {

    private Integer id;
    @NotBlank(message = "HouseNumber ne doit pas etre vide.")
    @NotEmpty(message = "HouseNumber ne doit pas etre vide.")
    @NotNull(message = "HouseNumber ne doit pas etre vide.")
    private Integer houseNumber;
    @NotEmpty(message = "ZipCode ne doit pas etre vide.")
    @NotNull(message = "ZipCode ne doit pas etre vide.")
    @NotBlank(message = "ZipCode ne doit pas etre vide.")
    private Integer zipCode;
    @NotEmpty(message = "City ne doit pas etre vide.")
    @NotNull(message = "City ne doit pas etre vide.")
    @NotBlank(message = "City ne doit pas etre vide.")
    private String city;
    @NotEmpty(message = "Country ne doit pas etre vide.")
    @NotNull(message = "Country ne doit pas etre vide.")
    @NotBlank(message = "Country ne doit pas etre vide.")
    private String country;
    @NotEmpty(message = "Street ne doit pas etre vide.")
    @NotNull(message = "Street ne doit pas etre vide.")
    @NotBlank(message = "Street ne doit pas etre vide.")
    private String street;
    private Integer userId;

    public static AddressDto fromEntity(Address address){
        return AddressDto.builder()
                .id(address.getId())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .street(address.getStreet())
                .userId(address.getUser().getId())
                .build();
    }


    public static Address toEntity(AddressDto addressDto){
        return Address.builder()
                .id(addressDto.getId())
                .houseNumber(addressDto.getHouseNumber())
                .zipCode(addressDto.getZipCode())
                .city(addressDto.getCity())
                .country(addressDto.getCountry())
                .street(addressDto.getStreet())
                .user(UserDto.toEntity(UserDto.builder().id(addressDto.getUserId()).build()))
                .build();
    }


}

