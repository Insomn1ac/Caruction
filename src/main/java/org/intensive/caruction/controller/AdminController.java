package org.intensive.caruction.controller;

import lombok.RequiredArgsConstructor;
import org.intensive.caruction.model.User;
import org.intensive.caruction.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping
    public List<User> adminGetAll() {
        return userService.getAll();
    }
}
