package com.lehcene.app_bancaire.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Contact extends AbstractEntity{
    private String firstname;
    private String lastname;
    private String email;
    private String ibn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
