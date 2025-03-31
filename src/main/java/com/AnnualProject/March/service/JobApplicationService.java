package com.AnnualProject.March.service;

import com.AnnualProject.March.model.Job;
import com.AnnualProject.March.model.JobApplication;
import com.AnnualProject.March.model.User;
import com.AnnualProject.March.repository.JobApplicationRepository;
import com.AnnualProject.March.repository.JobRepository;
import com.AnnualProject.March.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    public void applyForJob(Long jobId, MultipartFile resume, String coverLetter, String applicantEmail) throws IOException {
        User applicant = userRepository.findByEmail(applicantEmail)
                .orElseThrow(() -> new IllegalArgumentException("Applicant not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));

        String resumePath = "./uploads/" + resume.getOriginalFilename();
        resume.transferTo(new File(resumePath));

        JobApplication application = new JobApplication();
        application.setJob(job);
        application.setApplicant(applicant);
        application.setResumePath(resumePath);
        application.setCoverLetterPath(coverLetter);

        jobApplicationRepository.save(application);
    }
}