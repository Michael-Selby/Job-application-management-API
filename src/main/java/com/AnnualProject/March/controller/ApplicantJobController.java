package com.AnnualProject.March.controller;

import com.AnnualProject.March.service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/applicant")
@RequiredArgsConstructor
public class ApplicantJobController {
    private final JobApplicationService jobApplicationService;

    @PostMapping("/jobs/{jobId}/apply")
    public ResponseEntity<String> applyForJob(@PathVariable Long jobId,
                                              @RequestParam("resume") MultipartFile resume,
                                              @RequestParam("coverLetter") String coverLetter,
                                              Authentication authentication) throws IOException {
        jobApplicationService.applyForJob(jobId, resume, coverLetter, authentication.getName());
        return ResponseEntity.ok("Application submitted successfully!");
    }
}