package com.j_edulima.accouting.dto;

import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.model.enums.UserRole;

public record UserResponseDTO(String username, UserRole role) {

	public UserResponseDTO(User user) {
		this(user.getUsername(), user.getRole());
	}

}
