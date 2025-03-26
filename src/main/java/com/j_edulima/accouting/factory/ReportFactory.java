package com.j_edulima.accouting.factory;

import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.model.Report;
import com.j_edulima.accouting.model.enums.ReportType;

public class ReportFactory {

	public static Report generateReport(ReportType type, Company company) {
		return type.getStrategy().calculate(company);
	}
}
