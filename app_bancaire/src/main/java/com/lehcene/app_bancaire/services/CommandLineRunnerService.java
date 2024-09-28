package com.lehcene.app_bancaire.services;
import com.lehcene.app_bancaire.config.JwtUtils;
import com.lehcene.app_bancaire.models.User;
import com.lehcene.app_bancaire.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
@RequiredArgsConstructor
@Component
public class CommandLineRunnerService implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final RoleService roleService;
    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    @Override
    public void run(String... args) throws Exception {
        User user = User.builder()
                .firstname("Admin Lehcene")
                .lastname("Enset")
                .email("enset@gmail.com")
                .password(passwordEncoder.encode("enset@2024"))
                .role(roleService.getOrCreateRole(ROLE_ADMIN))
                .build();
        User userSaved =  userRepository.save(user);
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userSaved.getId());
        claims.put("fullName", userSaved.getFirstname() + "_" + userSaved.getLastname());
        claims.put("role", userSaved.getRole().getName());
        String token = jwtUtils.generateToken(userSaved, claims);
        User userAdminFinal = userRepository.findById(userSaved.getId()).get();
        userAdminFinal.setToken(token);
        userRepository.save(userAdminFinal);}


}
