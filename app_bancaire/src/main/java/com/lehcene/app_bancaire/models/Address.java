package com.lehcene.app_bancaire.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Address extends AbstractEntity{
    private Integer houseNumber;
    private Integer zipCode;
    private String city;
    private String country;
    private String street;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
