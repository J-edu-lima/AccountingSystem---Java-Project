package com.j_edulima.accouting.strategy;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.model.Report;
import com.j_edulima.accouting.model.Transaction;
import com.j_edulima.accouting.model.enums.EntryType;
import com.j_edulima.accouting.model.enums.ReportType;

public class WorkingCapitalCalculation implements ReportCalculationStrategy {

	@Override
	public Report calculate(Company company) {
		BigDecimal totalRevenue = company.getTransactions().stream().filter(t -> t.getType() == EntryType.GAIN)
				.map(Transaction::getValue).reduce(BigDecimal.ZERO, BigDecimal::add);

		BigDecimal totalExpenses = company.getTransactions().stream().filter(t -> t.getType() == EntryType.EXPENSE)
				.map(Transaction::getValue).reduce(BigDecimal.ZERO, BigDecimal::add);

		BigDecimal workingCapital = totalRevenue.subtract(totalExpenses);

		return new Report(ReportType.WORKING_CAPITAL, LocalDate.now(), company, workingCapital);
	}
}
