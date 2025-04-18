package com.j_edulima.accouting.service;

import java.util.List;

import com.j_edulima.accouting.dto.TransactionRequestDTO;
import com.j_edulima.accouting.model.Transaction;

public interface TransactionService {

	void register(TransactionRequestDTO transactionDTO, Long id);
	void delete(Long id);
	List<Transaction> findAll();
	Transaction findById(Long id);
}
