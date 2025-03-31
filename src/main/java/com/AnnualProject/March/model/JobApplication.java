package com.AnnualProject.March.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "job_applications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User applicant;

    private String resumePath;
    private String coverLetterPath;
    private String certificatesPath;
}