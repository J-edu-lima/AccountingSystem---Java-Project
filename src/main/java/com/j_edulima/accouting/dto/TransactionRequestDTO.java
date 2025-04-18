package com.j_edulima.accouting.dto;

import java.math.BigDecimal;

import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.model.Transaction;
import com.j_edulima.accouting.model.enums.EntryType;

public record TransactionRequestDTO(BigDecimal entryValue, EntryType type, Company company) {

	public TransactionRequestDTO(Transaction transaction) {
		this(transaction.getValue(), transaction.getType(), transaction.getCompany());
	}
}
