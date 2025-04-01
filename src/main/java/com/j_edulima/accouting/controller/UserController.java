package com.j_edulima.accouting.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j_edulima.accouting.dto.UserResponseDTO;
import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/v1/users")
@Tag(name = "users", description = "Gerenciamento de usuários")
public class UserController {

	@Autowired
	private UserService service;

	@DeleteMapping("/{id}")
	@Operation(summary = "Busca e deleta um usuário pelo ID", description = "Deleta um usuário pelo ID fornecido.")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.delete(id);

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Busca um usuário pelo ID", description = "Retorna um usuário pelo ID fornecido.")
	public ResponseEntity<UserResponseDTO> find(@PathVariable("id") Long id) {
		User user = service.find(id);

		return ResponseEntity.ok().body(new UserResponseDTO(user));
	}

	@GetMapping
	@Operation(summary = "Busca todos os usuários", description = "Retorna todos os usuários.")
	public ResponseEntity<List<UserResponseDTO>> findAll() {
		List<User> users = service.findAll();
		List<UserResponseDTO> userDTOs = users.stream().map(x -> new UserResponseDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(userDTOs);
	}
}
