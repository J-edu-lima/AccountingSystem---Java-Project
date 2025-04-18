package com.j_edulima.accouting.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j_edulima.accouting.dto.TransactionRequestDTO;
import com.j_edulima.accouting.dto.TransactionResponseDTO;
import com.j_edulima.accouting.model.Transaction;
import com.j_edulima.accouting.service.TransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/v1/transactions")
@Tag(name = "transaction", description = "Gerenciamento de transações")
public class TransactionController {

	@Autowired
	private TransactionService service;

	@PostMapping("/{id}")
	@Operation(summary = "Registra uma transação", description = "Registra uma transação no ID de uma empresa")
	public ResponseEntity<Void> register(@RequestBody TransactionRequestDTO transactionRequestDTO,
			@PathVariable("id") Long id) {
		service.register(transactionRequestDTO, id);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta uma transação registrada", description = "Deleta uma transação registrada com base no ID")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.delete(id);

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Busca uma transação", description = "Busca uma transação com base no ID fornecido")
	public ResponseEntity<TransactionResponseDTO> find(@PathVariable("id") Long id) {
		Transaction transaction = service.findById(id);

		return ResponseEntity.ok().body(new TransactionResponseDTO(transaction));
	}

	@GetMapping
	@Operation(summary = "Busca todas as transações", description = "Buscas todas as transações registradas no DB")
	public ResponseEntity<List<TransactionResponseDTO>> findAll() {
		List<Transaction> transactions = service.findAll();
		List<TransactionResponseDTO> transactionDTOs = transactions.stream().map(x -> new TransactionResponseDTO(x))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(transactionDTOs);
	}

}
