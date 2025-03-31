package com.AnnualProject.March.model;


import jakarta.persistence.*;
import lombok.Data;

import javax.annotation.processing.Generated;

@Data
@Entity
@Table(name = "Jobs")
public class Job {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long id;

    private String title;
    private String description;
    private String requirements;
    private String companyEmail;

}
