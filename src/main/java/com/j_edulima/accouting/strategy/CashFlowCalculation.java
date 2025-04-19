package com.j_edulima.accouting.strategy;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.model.Report;
import com.j_edulima.accouting.model.Transaction;
import com.j_edulima.accouting.model.enums.ReportType;

public class CashFlowCalculation implements ReportCalculationStrategy {
	@Override
	public Report calculate(Company company) {
		BigDecimal cashFlow = company.getTransactions().stream().map(Transaction::getValue).reduce(BigDecimal.ZERO,
				BigDecimal::add);

		return new Report(ReportType.CASH_FLOW, LocalDate.now(), company, cashFlow);
	}

}