package com.AnnualProject.March.service;

import com.AnnualProject.March.dto.UserDto;
import com.AnnualProject.March.model.User;
public interface UserService {
    User createAccount(UserDto userDto, boolean isAdmin); // Create user (admin or applicant)
    User findByEmail(String email);
}