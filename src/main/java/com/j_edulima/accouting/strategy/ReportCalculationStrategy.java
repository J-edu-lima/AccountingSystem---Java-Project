package com.j_edulima.accouting.strategy;

import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.model.Report;

public interface ReportCalculationStrategy {
	Report calculate(Company company);
}
