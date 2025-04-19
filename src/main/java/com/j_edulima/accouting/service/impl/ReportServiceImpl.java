package com.j_edulima.accouting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j_edulima.accouting.dto.ReportRequestDTO;
import com.j_edulima.accouting.factory.ReportFactory;
import com.j_edulima.accouting.handler.DataErrorException;
import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.model.Report;
import com.j_edulima.accouting.repository.CompanyRepository;
import com.j_edulima.accouting.repository.ReportRepository;
import com.j_edulima.accouting.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	ReportRepository repository;
	
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public void register(ReportRequestDTO reportDTO, Long companyId) {
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new DataErrorException());

		Report report = ReportFactory.generateReport(reportDTO.type(), company);
		repository.save(report);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Report> findAll() {
		return repository.findAll();
	}

	@Override
	public Report findById(Long id) {
		Report report = repository.findById(id).orElse(null);
		return report;
	}

}
