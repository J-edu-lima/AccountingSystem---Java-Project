package com.j_edulima.accouting.dto;

import com.j_edulima.accouting.model.valueObject.Password;

public record UserLoginRequestDTO(String username, Password password) {

}
