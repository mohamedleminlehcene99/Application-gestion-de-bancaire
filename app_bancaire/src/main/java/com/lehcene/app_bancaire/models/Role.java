package com.lehcene.app_bancaire.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Role extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    // Relation avec les utilisateurs
    @OneToMany(mappedBy = "role")  // Un rôle peut être attribué à plusieurs utilisateurs
    private List<User> users;

}
