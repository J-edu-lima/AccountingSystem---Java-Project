package com.j_edulima.accouting.security;

import com.j_edulima.accouting.model.entity.User;

public interface TokenInterface {

	public String generateToken(User user);
	public String validateToken(String token);
}
