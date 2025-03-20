package com.j_edulima.accouting.security.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j_edulima.accouting.dto.UserLoginRequestDTO;
import com.j_edulima.accouting.dto.UserRegisterDTO;
import com.j_edulima.accouting.security.auth.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserLoginRequestDTO loginRequestDTO) {

		return authenticationService.login(loginRequestDTO);
	}

	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody UserRegisterDTO registerDTO) {
		authenticationService.register(registerDTO);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}