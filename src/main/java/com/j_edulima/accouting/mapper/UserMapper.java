package com.j_edulima.accouting.mapper;

import com.j_edulima.accouting.dto.UserRegistrationDTO;
import com.j_edulima.accouting.model.entity.User;
import com.j_edulima.accouting.model.valueObject.Email;
import com.j_edulima.accouting.model.valueObject.Password;

public class UserMapper {

	public static UserRegistrationDTO toDto(User user) {
		return new UserRegistrationDTO(user.getId(), new Email(user.getUsername()), new Password(user.getPassword()));
	}

	public static User toEntity(UserRegistrationDTO dto) {
		return new User(dto.id(), new Email(dto.email().toString()), new Password(dto.password().toString()));
	}

}
