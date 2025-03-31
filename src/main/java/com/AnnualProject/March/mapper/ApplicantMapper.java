package com.AnnualProject.March.mapper;

import com.AnnualProject.March.dto.ApplicantDto;
import com.AnnualProject.March.model.JobApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApplicantMapper {
    ApplicantMapper INSTANCE = Mappers.getMapper(ApplicantMapper.class);

    @Mapping(source = "job.id", target = "jobId")
    ApplicantDto toDto(JobApplication jobApplication);

    @Mapping(source = "jobId", target = "job.id")
    JobApplication toEntity(ApplicantDto applicantDto);
}