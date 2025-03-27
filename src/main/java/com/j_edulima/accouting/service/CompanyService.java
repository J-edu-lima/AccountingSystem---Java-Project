package com.j_edulima.accouting.service;

import java.util.List;

import com.j_edulima.accouting.dto.CompanyRequestDTO;
import com.j_edulima.accouting.model.Company;


public interface CompanyService {

	void register(CompanyRequestDTO companyDTO, Long id);
	void delete(Long id);
	List<Company> findAll();
	Company findById(Long id);
}
