package com.j_edulima.accouting.security.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.j_edulima.accouting.dto.UserLoginRequestDTO;
import com.j_edulima.accouting.dto.UserRegisterDTO;

public interface AuthenticationInterface extends UserDetailsService {
	
	void register(UserRegisterDTO userDTO);
	ResponseEntity<Object> login(UserLoginRequestDTO login);
	
	
}
