package com.AnnualProject.March.controller;

import com.AnnualProject.March.dto.LoginRequest;
import com.AnnualProject.March.dto.UserDto;
import com.AnnualProject.March.model.User; // Import your custom User entity
import com.AnnualProject.March.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> adminSignup(@RequestBody UserDto userDto) {
        User admin = userService.createAccount(userDto, true); // Assign `ROLE_ADMIN`
        return ResponseEntity.ok(admin);
    }
    @PostMapping("/admin-login")
    public ResponseEntity<String> adminLogin(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok("Admin logged in successfully!");
    }
}