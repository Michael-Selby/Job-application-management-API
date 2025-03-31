package com.AnnualProject.March.mapper;

import com.AnnualProject.March.dto.JobDto;
import com.AnnualProject.March.model.Job;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface JobMapper {
    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);
    JobDto toDto(Job job);
    Job toEntity(JobDto jobDto);
}
