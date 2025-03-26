package com.j_edulima.accouting.model.enums;

import com.j_edulima.accouting.strategy.CashFlowCalculation;
import com.j_edulima.accouting.strategy.ReportCalculationStrategy;
import com.j_edulima.accouting.strategy.WorkingCapitalCalculation;

public enum ReportType {
	
	CASH_FLOW {
		@Override
		public ReportCalculationStrategy getStrategy() {
			return new CashFlowCalculation();
		}
	},
	WORKING_CAPITAL {
		@Override
		public ReportCalculationStrategy getStrategy() {
			return new WorkingCapitalCalculation();
		}
	};

	public abstract ReportCalculationStrategy getStrategy();
}
