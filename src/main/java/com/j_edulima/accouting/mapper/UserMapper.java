package com.j_edulima.accouting.mapper;

import com.j_edulima.accouting.dto.UserRegisterDTO;
import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.model.enums.UserRole;
import com.j_edulima.accouting.model.valueObject.Email;
import com.j_edulima.accouting.model.valueObject.Password;

public class UserMapper {

	public static UserRegisterDTO toDto(User user) {
		return new UserRegisterDTO(new Email(user.getUsername()), new Password(user.getPassword()));
	}

	public static User toEntity(UserRegisterDTO dto) {
		return new User(new Email(dto.email().toString()), new Password(dto.password().passwordEncoder(dto.password())),
				UserRole.USER);
	}

}
