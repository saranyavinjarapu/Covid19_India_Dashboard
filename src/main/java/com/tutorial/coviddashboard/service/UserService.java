package com.tutorial.coviddashboard.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tutorial.coviddashboard.model.User;
import com.tutorial.coviddashboard.web.dto.UserRegistrationDto;


public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
	
}




