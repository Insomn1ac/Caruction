package org.intensive.caruction.controller;

import lombok.RequiredArgsConstructor;
import org.intensive.caruction.model.User;
import org.intensive.caruction.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;


    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userGet() {
        return "User page";
    }
    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public User userGet(@PathVariable int id) {
        return userService.getById(id);
    }
}