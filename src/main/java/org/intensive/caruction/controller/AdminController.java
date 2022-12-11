package org.intensive.caruction.controller;

import lombok.RequiredArgsConstructor;
import org.intensive.caruction.model.AdminRequest;
import org.intensive.caruction.model.User;
import org.intensive.caruction.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    private final UserService userService;

    @GetMapping
    public List<User> adminGetAll() {
        return userService.getAll();
    }

    public User get(int id) {
        return userService.get(id);
    }

    @GetMapping("/by-email")
    public ResponseEntity<User> getByEmail(@RequestParam String email) {
        return userService.getByEmail(email);
    }

    @PatchMapping("/{id}")
    public void enable(@PathVariable int id,@RequestParam boolean enabled) {
        userService.enable(id, enabled);
    }

    @GetMapping("/admin_requests")
    public List<AdminRequest> getAllAdminRequests() {
        return userService.getAllAdminRequests();
    }

    @PostMapping("/admin_requests/{id}")
    public void approveAdminRequest(@PathVariable int id) {
        userService.approveAdminRequest(id);
    }
}
