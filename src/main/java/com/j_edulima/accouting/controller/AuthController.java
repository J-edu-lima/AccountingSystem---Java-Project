package com.j_edulima.accouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j_edulima.accouting.config.security.auth.AuthenticationService;
import com.j_edulima.accouting.dto.UserLoginRequestDTO;
import com.j_edulima.accouting.dto.UserRegisterDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "auth", description = "Gerenciamento de autenticação")
public class AuthController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/login")
	@Operation(summary = "Fornece a autenticação ao usuário", description = "Gera um Token para que o usuário possa acessar requisições que necessitem de permissão.")
	public ResponseEntity<Object> login(@RequestBody UserLoginRequestDTO loginRequestDTO) {

		return authenticationService.login(loginRequestDTO);
	}

	@PostMapping("/register")
	@Operation(summary = "Registra um usuário por meio do Email e Password", description = "Registra um usuário no banco de dados.")
	public ResponseEntity<Object> register(@RequestBody UserRegisterDTO registerDTO) {
		authenticationService.register(registerDTO);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}