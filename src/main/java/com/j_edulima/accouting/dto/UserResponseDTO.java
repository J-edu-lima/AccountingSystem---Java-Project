package com.j_edulima.accouting.dto;

import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.model.enums.UserRole;
import com.j_edulima.accouting.model.valueObject.Email;

public record UserResponseDTO(Email email, UserRole role) {

	public UserResponseDTO(User user) {
		this(new Email(user.getUsername()), user.getRole());
	}

}
