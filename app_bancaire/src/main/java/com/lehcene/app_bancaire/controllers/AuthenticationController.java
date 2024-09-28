package com.lehcene.app_bancaire.controllers;

import com.lehcene.app_bancaire.dto.AuthenticationRequest;
import com.lehcene.app_bancaire.dto.AuthenticationResponse;
import com.lehcene.app_bancaire.dto.RegistrationRequest;
import com.lehcene.app_bancaire.dto.UserDto;
import com.lehcene.app_bancaire.services.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
@Tag(name = "Authentication")
public class AuthenticationController {

    private final UserServiceImpl userService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(userService.authentication(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrationRequest request){
        return ResponseEntity.ok(userService.registration(request,false));
    }

    @PostMapping("/create/new/admin")
    public ResponseEntity<AuthenticationResponse> createNewAdmin(@RequestBody RegistrationRequest request){
        return ResponseEntity.ok(userService.registration(request,true));
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Word";
    }
}

