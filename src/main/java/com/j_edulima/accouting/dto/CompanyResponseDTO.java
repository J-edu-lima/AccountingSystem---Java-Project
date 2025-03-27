package com.j_edulima.accouting.dto;

import java.util.List;

import com.j_edulima.accouting.model.Report;
import com.j_edulima.accouting.model.Transaction;
import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.model.valueObject.Name;

public record CompanyResponseDTO(Name name, User user, List<Transaction> transactions, List<Report> reports) {

}
