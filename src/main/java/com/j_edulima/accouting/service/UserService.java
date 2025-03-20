package com.j_edulima.accouting.service;

import java.util.List;

import com.j_edulima.accouting.model.User;

public interface UserService {
	
	void delete(Long id);
	User find(Long id);
	List<User> findAll();

}
