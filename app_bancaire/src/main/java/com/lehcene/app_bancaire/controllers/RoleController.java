package com.lehcene.app_bancaire.controllers;

import com.lehcene.app_bancaire.dto.RoleResponse;
import com.lehcene.app_bancaire.services.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
@Tag(name = "Role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/")
    public ResponseEntity<List<RoleResponse>> findAll(){
        return ResponseEntity.ok(roleService.findAll());
    }

}
