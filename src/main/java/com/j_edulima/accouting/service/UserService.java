package com.j_edulima.accouting.service;

import java.util.List;

import com.j_edulima.accouting.dto.UserRegistrationDTO;
import com.j_edulima.accouting.model.entity.User;

public interface UserService {

	void create(UserRegistrationDTO userDTO);
	void delete(Long id);
	List<User> searchAll();
	User search(Long id);
}
