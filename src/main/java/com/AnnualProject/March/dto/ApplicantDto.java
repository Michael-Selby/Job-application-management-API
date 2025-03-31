package com.AnnualProject.March.dto;

import lombok.Data;

@Data
public class ApplicantDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String resumeUrl;
    private String coverLetterUrl;
    private String certificatesUrl;
    private Long jobId;
}
