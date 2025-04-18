package com.j_edulima.accouting.dto;

import java.math.BigDecimal;

import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.model.Transaction;
import com.j_edulima.accouting.model.enums.EntryType;

public record TransactionResponseDTO(BigDecimal entryValue, EntryType type, Company company) {

	public TransactionResponseDTO(Transaction transaction) {
		this(transaction.getValue(), transaction.getType(), transaction.getCompany());
	}
}