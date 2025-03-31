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
@RequestMapping("/api/v1/applicant")
@RequiredArgsConstructor
public class ApplicantController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> applicantSignup(@RequestBody UserDto userDto) {
        User applicant = userService.createAccount(userDto, false); // Assign `ROLE_USER`
        return ResponseEntity.ok(applicant);
    }
    @PostMapping("/applicant-login")
    public ResponseEntity<String> applicantLogin(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok("Applicant logged in successfully!");
    }
}