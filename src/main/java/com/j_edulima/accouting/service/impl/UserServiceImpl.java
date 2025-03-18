package com.j_edulima.accouting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.j_edulima.accouting.dto.UserRegistrationDTO;
import com.j_edulima.accouting.mapper.UserMapper;
import com.j_edulima.accouting.model.entity.User;
import com.j_edulima.accouting.repository.UserRepository;
import com.j_edulima.accouting.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public void create(UserRegistrationDTO userDTO) {

		User user = UserMapper.toEntity(userDTO);
		repository.save(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User search(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
