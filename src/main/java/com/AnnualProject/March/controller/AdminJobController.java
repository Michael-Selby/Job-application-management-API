package com.AnnualProject.March.controller;

import com.AnnualProject.March.dto.JobDto;
import com.AnnualProject.March.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminJobController {
    private final JobService jobService;

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody JobDto jobDto, Authentication authentication) {
        jobService.createJob(jobDto, authentication.getName());
        return ResponseEntity.ok("Job created successfully!");
    }
}