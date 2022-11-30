package org.intensive.caruction.service;

import lombok.RequiredArgsConstructor;
import org.intensive.caruction.model.Role;
import org.intensive.caruction.model.User;
import org.intensive.caruction.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional()
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(Role.ADMIN, Role.USER));
        userRepository.save(user);
    }
}
