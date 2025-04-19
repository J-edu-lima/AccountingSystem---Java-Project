package com.j_edulima.accouting.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.j_edulima.accouting.model.Report;
import com.j_edulima.accouting.model.enums.ReportType;

public record ReportResponseDTO(ReportType type, LocalDate generationDate, BigDecimal calculatedValue, Long companyId) {

	public ReportResponseDTO(Report report) {
		this(report.getType(), report.getGenerationDate(), report.getCalculatedValue(), report.getCompany().getId());
	}

}
