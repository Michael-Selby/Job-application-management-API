package com.AnnualProject.March.repository;

import com.AnnualProject.March.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication,Long> {
}
