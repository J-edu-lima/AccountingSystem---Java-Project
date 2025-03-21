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

import com.j_edulima.accouting.dto.UserRequestDTO;
import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.service.UserService;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

	@Autowired
	private UserService service;

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.delete(id);

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserRequestDTO> find(@PathVariable("id") Long id) {
		User user = service.find(id);

		return ResponseEntity.ok().body(new UserRequestDTO(user));
	}

	@GetMapping
	public ResponseEntity<List<UserRequestDTO>> findAll() {
		List<User> users = service.findAll();
		List<UserRequestDTO> userDTOs = users.stream().map(x -> new UserRequestDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(userDTOs);
	}
}
