package com.lehcene.app_bancaire.controllers;

import com.lehcene.app_bancaire.dto.ChangeRoleUserRequest;
import com.lehcene.app_bancaire.dto.UserDto;
import com.lehcene.app_bancaire.services.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "User")
public class UserRestController {

    private final UserServiceImpl userService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable("user_id") Integer user_id){
        return ResponseEntity.ok(userService.findById(user_id));
    }


    @DeleteMapping("/{user_id}")
    public ResponseEntity<Void> delete(@PathVariable("user_id") Integer user_id){
        userService.delete(user_id);
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/validate/account/{user_id}")
    public ResponseEntity<Integer> validateAccount(@PathVariable("user_id") Integer user_id){
        return ResponseEntity.ok(userService.valaidateAccountUserById(user_id));
    }

    @PatchMapping("/invalidate/account/{user_id}")
    public ResponseEntity<Integer> invalidateAccount(@PathVariable("user_id") Integer user_id){
        return ResponseEntity.ok(userService.inValidateAccountUserById(user_id));
    }

    @PostMapping("/changer/user/role")
    public ResponseEntity<Void> changerRoleUser(@RequestBody ChangeRoleUserRequest changeRoleUserRequest){
        userService.changerRoleUser(changeRoleUserRequest);
        return ResponseEntity.accepted().build();
    }

}

