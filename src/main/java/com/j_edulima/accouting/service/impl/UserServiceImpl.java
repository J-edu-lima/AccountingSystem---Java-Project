package com.j_edulima.accouting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.repository.UserRepository;
import com.j_edulima.accouting.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public User find(Long id) {
		User user = repository.findById(id).orElseThrow();

		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> usuarios = repository.findAll();

		return usuarios;
	}

}
