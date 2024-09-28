package com.lehcene.app_bancaire.dto;


import com.lehcene.app_bancaire.models.Role;
import com.lehcene.app_bancaire.models.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto{

    private Integer id;
    @NotNull(message = "FirstName ne doit pas etre vide.")
    @NotEmpty(message = "FirstName ne doit pas etre vide.")
    @NotBlank(message = "FirstName ne doit pas etre vide.")
    private String firstname;
    @NotEmpty(message = "LastName ne doit pas etre vide.")
    @NotNull(message = "LastName ne doit pas etre vide.")
    @NotBlank(message = "LastName ne doit pas etre vide.")
    private String lastname;
    @NotNull(message = "Cette champs ne doit pas etre vide.")
    @NotEmpty(message = "Cette champs ne doit pas etre vide.")
    @NotBlank(message = "Cette champs ne doit pas etre vide.")
    @Email(message = "Le format du email n'est pas valide.")
    private String email;
    @NotEmpty(message = "Le mot de passe ne doit pas etre vide.")
    @NotNull(message = "Le mot de passe ne doit pas etre vide.")
    @NotBlank(message = "Le mot de passe ne doit pas etre vide.")
    @Size(min = 8, max = 15, message = "Les nombres de caracters pour mot de passe doit etre compris entre 8 et 10 caractesr.")
    private String password;

    private boolean active;

    private Integer roleId;

    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .active(user.isActive())
                .password(user.getPassword())
                .roleId(user.getRole().getId())
                .build();
    }
//.roleDto(RoleDto.fromEntity(user.getRole()))

    public static User toEntity(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(
                        Role.builder().id(userDto.getRoleId()).build()
                )
                .build();
    }

}
