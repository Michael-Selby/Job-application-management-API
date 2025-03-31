package com.AnnualProject.March.mapper;
import com.AnnualProject.March.dto.UserDto;
import com.AnnualProject.March.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user); // Convert User entity to UserDto
    User toEntity(UserDto userDto); // Convert UserDto to User entity
}