package com.j_edulima.accouting.mapper;

import com.j_edulima.accouting.dto.ReportRequestDTO;
import com.j_edulima.accouting.dto.ReportResponseDTO;
import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.model.Report;

public class ReportMapper {

	public static ReportRequestDTO toDto(Report report, Company company) {
		return new ReportRequestDTO(report.getType(), report.getGenerationDate(), report.getCalculatedValue(), company);
	}

	public static Report toEntity(ReportRequestDTO dto, Company company) {
		return new Report(dto.type(), dto.generationDate(), company, dto.calculatedValue());
	}

	public static ReportResponseDTO toDtoResponse(Report report, Company company) {
		return new ReportResponseDTO(report.getType(), report.getGenerationDate(), report.getCalculatedValue(),
				company.getId());
	}

	public static Report toEntityResponse(ReportResponseDTO dto, Company company) {
		return new Report(dto.type(), dto.generationDate(), company, dto.calculatedValue());
	}
}
