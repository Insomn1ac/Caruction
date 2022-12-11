package org.intensive.caruction.controller;

import lombok.RequiredArgsConstructor;
import org.intensive.caruction.dto.AdminRequestDTO;
import org.intensive.caruction.dto.UserDTO;
import org.intensive.caruction.model.User;
import org.intensive.caruction.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public class UserController {

    private final UserService userService;

    @GetMapping
    public User userGet() {
        return userService.userGet();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody UserDTO userDTO, @PathVariable int id) {
        userService.update(userDTO, id);
    }

    @PostMapping("/admin_request")
    public void adminRequest(@RequestBody AdminRequestDTO adminRequestDTO) {
        userService.adminRequest(adminRequestDTO);
    }
}