package com.AnnualProject.March.service;

import com.AnnualProject.March.dto.JobDto;
import com.AnnualProject.March.model.Job;
import com.AnnualProject.March.model.User;
import com.AnnualProject.March.repository.JobRepository;
import com.AnnualProject.March.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    public void createJob(JobDto jobDto, String adminEmail) {
        User admin = userRepository.findByEmail(adminEmail)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));

        Job job = new Job();
        job.setTitle(jobDto.getTitle());
        job.setDescription(jobDto.getDescription());
        job.setRequirements(jobDto.getRequirements());
        jobRepository.save(job);
    }
}