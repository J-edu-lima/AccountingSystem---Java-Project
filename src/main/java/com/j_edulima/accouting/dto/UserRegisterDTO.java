package com.j_edulima.accouting.dto;

import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.model.valueObject.Email;
import com.j_edulima.accouting.model.valueObject.Password;

public record UserRegisterDTO(Email email, Password password) {

	public UserRegisterDTO(User user) {
		this(new Email(user.getUsername()), new Password(user.getPassword()));
	}
}
