package com.j_edulima.accouting.dto;

import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.model.valueObject.Email;
import com.j_edulima.accouting.model.valueObject.Password;

public record UserRegisterDTO(String username, Email email, Password password) {

	public UserRegisterDTO(User user) {
		this(user.getUsername(), new Email(user.getEmail()), new Password(user.getPassword()));
	}
}
