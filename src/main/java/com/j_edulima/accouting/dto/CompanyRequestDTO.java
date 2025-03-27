package com.j_edulima.accouting.dto;

import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.model.valueObject.Name;

public record CompanyRequestDTO(Name name, User user) {

}
