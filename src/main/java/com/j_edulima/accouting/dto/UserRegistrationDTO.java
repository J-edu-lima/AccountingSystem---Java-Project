package com.j_edulima.accouting.dto;

import com.j_edulima.accouting.model.valueObject.Email;
import com.j_edulima.accouting.model.valueObject.Password;

public record UserRegistrationDTO(Long id, Email email, Password password) {

}
