package com.lehcene.app_bancaire.services;

import com.lehcene.app_bancaire.dto.RoleResponse;
import com.lehcene.app_bancaire.models.Role;
import com.lehcene.app_bancaire.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getOrCreateRole(String roleName) {
        return roleRepository.findByName(roleName).orElseGet(() -> {
            Role newRole = new Role();
            newRole.setName(roleName);
            return roleRepository.save(newRole);
        });
    }

    public List<RoleResponse> findAll(){
        return roleRepository.findAll().stream().map(
                role -> new RoleResponse(role.getId(), role.getName())
        ).collect(Collectors.toList());
    }

}
