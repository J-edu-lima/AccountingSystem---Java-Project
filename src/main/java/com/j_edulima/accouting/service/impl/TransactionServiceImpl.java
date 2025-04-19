package com.j_edulima.accouting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j_edulima.accouting.dto.TransactionRequestDTO;
import com.j_edulima.accouting.handler.DataErrorException;
import com.j_edulima.accouting.mapper.TransactionMapper;
import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.model.Transaction;
import com.j_edulima.accouting.repository.CompanyRepository;
import com.j_edulima.accouting.repository.TransactionRepository;
import com.j_edulima.accouting.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository repository;

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public void register(TransactionRequestDTO transactionDTO, Long id) {
		Company company = companyRepository.findById(id).orElseThrow(() -> new DataErrorException());
		Transaction transaction = TransactionMapper.toEntity(transactionDTO, company);

		repository.save(transaction);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Transaction> findAll() {
		return repository.findAll();
	}

	@Override
	public Transaction findById(Long id) {
		Transaction transaction = repository.findById(id).orElseThrow();

		return transaction;
	}

}
