package com.j_edulima.accouting.mapper;

import java.util.List;

import com.j_edulima.accouting.dto.CompanyRequestDTO;
import com.j_edulima.accouting.dto.CompanyResponseDTO;
import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.model.Report;
import com.j_edulima.accouting.model.Transaction;
import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.model.valueObject.Name;

public class CompanyMapper {

	public static CompanyRequestDTO toDto(Company company, User user) {
		return new CompanyRequestDTO(new Name(company.getName().toString()), user);
	}

	public static Company toEntity(CompanyRequestDTO dto, User user) {
		return new Company(new Name(dto.name().toString()), user);
	}

	public static CompanyResponseDTO toDto(Company company, User user, List<Transaction> transactions,
			List<Report> reports) {
		return new CompanyResponseDTO(new Name(company.getName().toString()), user.getId().toString(), transactions,
				reports);
	}

	public static Company toEntity(CompanyResponseDTO dto, User user, List<Transaction> transactions,
			List<Report> reports) {
		return new Company(new Name(dto.name().toString()), user, transactions, reports);
	}
}
