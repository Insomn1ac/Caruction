package org.intensive.caruction.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.intensive.caruction.dto.AdminRequestDTO;
import org.intensive.caruction.dto.UserDTO;
import org.intensive.caruction.exception.ElementNotFoundException;
import org.intensive.caruction.model.AdminRequest;
import org.intensive.caruction.model.Role;
import org.intensive.caruction.model.User;
import org.intensive.caruction.repository.AdminRequestRepository;
import org.intensive.caruction.repository.UserRepository;
import org.intensive.caruction.security.UserDetailsImpl;
import org.intensive.caruction.util.ValidationUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class UserService {

    private final AdminRequestRepository adminRequestRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User get(int id) {
        return userRepository.findById(id).orElseThrow(() -> new ElementNotFoundException("User not found"));
    }

    public User userGet() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userRepository.findById(userDetails.getUser().getId()).orElseThrow(() -> new ElementNotFoundException("User not found"));
    }

    public List<User> getAll() {
        log.info("getAll");
        return userRepository.findAll();
    }

    public User getById(int id) {
        log.info("get user by id");
        return userRepository.findById(id).get();
    }

    public ResponseEntity<User> getByEmail(String email) {
        log.info("getByEmail {}", email);
        Assert.notNull(email, "email must not be null");
        return ValidationUtil.checkNotFound(ResponseEntity.of(userRepository.findByEmailIgnoreCase(email)), "email=" + email);
    }

    @Transactional
    public void enable(int id, boolean enabled) {
        log.info(enabled ? "enable {}" : "disable {}", id);
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(value -> value.setEnabled(enabled));
    }

    @Transactional
    public void delete(int id) {
        log.info("delete{}", id);
        ValidationUtil.checkModification(userRepository.delete(id), id);
    }

    @Transactional
    public void update(UserDTO userDTO, int id) {
        log.info("update {} with id={}", userDTO, userDTO.getId());
        User user = userRepository.findById(id).get();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void adminRequest(AdminRequestDTO adminRequestDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        AdminRequest adminRequest = AdminRequest.builder()
                .description(adminRequestDTO.getDescription())
                .user(userDetails.getUser())
                .build();

        adminRequestRepository.save(adminRequest);
    }

    public List<AdminRequest> getAllAdminRequests() {
        return new ArrayList<>(adminRequestRepository.findAll());
    }

    @Transactional
    public void approveAdminRequest(int id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(value -> value.setRoles(Set.of(Role.valueOf("ADMIN"), Role.valueOf("USER"))));
        userRepository.save(user.get());
    }

}
