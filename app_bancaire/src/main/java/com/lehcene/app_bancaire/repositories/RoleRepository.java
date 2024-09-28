package com.lehcene.app_bancaire.repositories;

import com.lehcene.app_bancaire.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String roleName);

    boolean existsByName(String roleAdmin);
}
