package com.lehcene.app_bancaire.services.impl;

import com.lehcene.app_bancaire.config.JwtUtils;
import com.lehcene.app_bancaire.dto.*;
import com.lehcene.app_bancaire.exceptions.EmailAlreadyExistsException;
import com.lehcene.app_bancaire.exceptions.OperationNonPermittedException;
import com.lehcene.app_bancaire.models.Account;
import com.lehcene.app_bancaire.models.Role;
import com.lehcene.app_bancaire.models.User;
import com.lehcene.app_bancaire.repositories.AccountRepository;
import com.lehcene.app_bancaire.repositories.UserRepository;
import com.lehcene.app_bancaire.services.AccountService;
import com.lehcene.app_bancaire.services.RoleService;
import com.lehcene.app_bancaire.services.UserService;
import com.lehcene.app_bancaire.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ObjectsValidator<UserDto> validator;
    private final AccountService accountService;
    private final AccountRepository accountRepository;
    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authManager;
    private static final String ROLE_USER = "ROLE_USER";
    private static final String ROLE_ADMIN = "ROLE_ADMIN";


    @Override
    public Integer save(UserDto userDto) {

        validator.validate(userDto);

        User user = UserDto.toEntity(userDto);

        return userRepository.save(user).getId();
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return userRepository.findById(id).map(UserDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("Not found user with this provided ID"));
    }

    @Override
    public void delete(Integer id) {
                userRepository.deleteById(id);
    }

    @Override
    public int valaidateAccountUserById(Integer id) {

        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found user with this provided ID"));

       if (user.isActive()){
        throw new OperationNonPermittedException(
                "User has already account active",
                "Activated an account",
                "User service",
                "account activation"
        );
       }

        Optional<Account> accountExist = accountRepository.findByUserId(id);
       if (accountExist.isPresent()){
           user.setActive(true);
         return   userRepository.save(user).getId();
       }

       //créer un compte & et activer

       AccountDto accountDto = AccountDto.builder()
               .userId(id)
               .build();

       accountService.save(accountDto);

       user.setActive(true);

        return userRepository.save(user).getId();
    }

    @Override
    public int inValidateAccountUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found user with this provided ID"));

        if (!user.isActive()){
            throw new OperationNonPermittedException(
                    "User has already an account inactive",
                    "inactive account",
                    "User service",
                    "InActive account "
            );
        }

        user.setActive(false);

        return userRepository.save(user).getId();
    }

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest request) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userRepository.findByEmail(request.getEmail()).get();

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userId",user.getId());
        claims.put("fullName",user.getFirstname() + ' ' +  user.getLastname());
        claims.put("role", user.getRole().getName());

        String token = jwtUtils.generateToken(user, claims);

        return AuthenticationResponse.builder().token(token).build();
    }

    @Transactional
    @Override
    public AuthenticationResponse registration(RegistrationRequest request, boolean isAdmin) {

        UserDto userDto = UserDto.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        validator.validate(userDto);

        User user = UserDto.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("This email already exists.");
        }

        //Assigner le role USER ou ADMIN

        user.setRole(roleService.getOrCreateRole(isAdmin ? ROLE_ADMIN : ROLE_USER));

        var savedUser = userRepository.save(user);

        Map<String, Object> claims = new HashMap<>();

        claims.put("userId",savedUser.getId());
        claims.put("fullName", savedUser.getFirstname() + ' ' + savedUser.getLastname());
        claims.put("role", savedUser.getRole().getName());

        String token = jwtUtils.generateToken(savedUser, claims);

        return AuthenticationResponse.builder().token(token).build();
    }

    @Override
    public void changerRoleUser(ChangeRoleUserRequest changeRoleUserRequest) {
        User user = userRepository.findById(changeRoleUserRequest.getUser_id()).orElseThrow(
                () -> new EntityNotFoundException("Not found user with this provided ID")
        );

        user.setRole(
                Role.builder().id(changeRoleUserRequest.getRole_id()).build()
        );

        userRepository.save(user);
    }


}

