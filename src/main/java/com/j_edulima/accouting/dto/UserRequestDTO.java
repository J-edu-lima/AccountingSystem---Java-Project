package com.j_edulima.accouting.dto;

import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.model.enums.UserRole;
import com.j_edulima.accouting.model.valueObject.Email;
import com.j_edulima.accouting.model.valueObject.Password;

public record UserRequestDTO(String username, Email email, Password password, UserRole role) {

	public UserRequestDTO(User user) {
		this(user.getUsername(), new Email(user.getEmail()), new Password(user.getPassword()), user.getRole());
	}

}
