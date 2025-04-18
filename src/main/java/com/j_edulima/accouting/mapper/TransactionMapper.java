package com.j_edulima.accouting.mapper;

import com.j_edulima.accouting.dto.TransactionRequestDTO;
import com.j_edulima.accouting.dto.TransactionResponseDTO;
import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.model.Transaction;

public class TransactionMapper {

	public static TransactionRequestDTO toDto(Transaction transaction, Company company) {
		return new TransactionRequestDTO(transaction.getValue(), transaction.getType(), company);
	}

	public static Transaction toEntity(TransactionRequestDTO dto, Company company) {
		return new Transaction(dto.entryValue(), dto.type(), company);
	}

	public static TransactionResponseDTO toDtoResponse(Transaction transaction, Company company1) {
		return new TransactionResponseDTO(transaction.getValue(), transaction.getType(), company1);
	}

	public static Transaction toEntityResponse(TransactionResponseDTO dto, Company company) {
		return new Transaction(dto.entryValue(), dto.type(), company);
	}
}
