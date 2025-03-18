package com.j_edulima.accouting.dto;

import com.j_edulima.accouting.model.entity.User;
import com.j_edulima.accouting.model.valueObject.Email;
import com.j_edulima.accouting.model.valueObject.Password;

public record UserRegistrationDTO(Long id, Email email, Password password) {

	public UserRegistrationDTO(User user) {
		this(user.getId(), new Email(user.getUsername()), new Password(user.getPassword()));
	}
}
