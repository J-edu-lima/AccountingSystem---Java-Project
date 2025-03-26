package com.j_edulima.accouting.config.security.token;

import com.j_edulima.accouting.model.User;

import jakarta.servlet.http.HttpServletRequest;

public interface TokenInterface {

	public String generateToken(User user);
	public String validateToken(String token);
	public String recoverToken(HttpServletRequest request);
}
