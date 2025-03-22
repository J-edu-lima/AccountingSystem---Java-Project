package com.j_edulima.accouting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j_edulima.accouting.handler.ObjectNotFoundException;
import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.repository.UserRepository;
import com.j_edulima.accouting.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public void delete(Long id) {
		if (!repository.findById(id).isPresent()) {
			throw new ObjectNotFoundException("Objeto com ID " + id + " não encontrado");
		}
		repository.deleteById(id);
	}

	@Override
	public User find(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Usuário com ID " + id + " não encontrado"));
	}

	@Override
	public List<User> findAll() {
		List<User> users = repository.findAll();
		if (users.isEmpty()) {
			throw new ObjectNotFoundException("Nenhum usuário encontrado no sistema");
		}
		return users;
	}
}