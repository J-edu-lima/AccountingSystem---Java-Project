package com.j_edulima.accouting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j_edulima.accouting.dto.CompanyRequestDTO;
import com.j_edulima.accouting.mapper.CompanyMapper;
import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.repository.CompanyRepository;
import com.j_edulima.accouting.repository.UserRepository;
import com.j_edulima.accouting.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void register(CompanyRequestDTO companyDTO, Long id) {
		User user = userRepository.findById(id).orElseThrow();
		Company company = CompanyMapper.toEntity(companyDTO, user);
		repository.save(company);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Company> findAll() {
		return repository.findAll();
	}

	@Override
	public Company findById(Long id) {
		Company company = repository.findById(id).orElseThrow();
		return company;
	}

}
