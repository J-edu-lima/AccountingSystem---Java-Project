package com.j_edulima.accouting.service;

import java.util.List;

import com.j_edulima.accouting.dto.ReportRequestDTO;
import com.j_edulima.accouting.model.Report;


public interface ReportService {

	void register(ReportRequestDTO reportDTO, Long id);
	void delete(Long id);
	List<Report> findAll();
	Report findById(Long id);
}
