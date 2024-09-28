package com.lehcene.app_bancaire.dto;

import com.lehcene.app_bancaire.models.Contact;
import jakarta.validation.constraints.Email;
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
public class ContactDto {

    private Integer id;
    @NotEmpty(message = "L nom ne doit pas etre vide.")
    @NotNull(message = "Le nom ne doit pas etre vide.")
    @NotBlank(message = "Le nom ne doit pas etre vide.")
    private String firstname;
    @NotEmpty(message = "Le prenom ne doit pas etre vide.")
    @NotNull(message = "Le prenom ne doit pas etre vide.")
    @NotBlank(message = "Le prenom ne doit pas etre vide.")
    private String lastname;
    @NotEmpty(message = "Email ne doit pas etre vide.")
    @NotNull(message = "Email ne doit pas etre vide.")
    @NotBlank(message = "Email ne doit pas etre vide.")
    @Email(message = "Entre un email valide.")
    private String email;
    @NotEmpty
    @NotNull
    @NotBlank
    private String ibn;
    private Integer userId;

    public static ContactDto fromEntity(Contact contact){
        return ContactDto.builder()
                .id(contact.getId())
                .firstname(contact.getFirstname())
                .lastname(contact.getLastname())
                .email(contact.getEmail())
                .ibn(contact.getIbn())
                .userId(contact.getUser().getId())
                .build();
    }

    public static Contact toEntity(ContactDto contactDto){
        return Contact.builder()
                .id(contactDto.getId())
                .firstname(contactDto.getFirstname())
                .lastname(contactDto.getLastname())
                .email(contactDto.getEmail())
                .ibn(contactDto.getIbn())
                .user(UserDto.toEntity(UserDto.builder().id(contactDto.getUserId()).build()))
                .build();
    }

}
