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

import com.j_edulima.accouting.dto.ReportRequestDTO;
import com.j_edulima.accouting.dto.ReportResponseDTO;
import com.j_edulima.accouting.model.Report;
import com.j_edulima.accouting.service.ReportService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/v1/reports")
@Tag(name = "reports", description = "Gerenciamento de relatórios")
public class ReportController {

	@Autowired
	private ReportService service;

	@PostMapping("/{id}")
	@Operation(summary = "Registra o relatório", description = "Registra o relatório no ID de o empresa")
	public ResponseEntity<Void> register(@RequestBody ReportRequestDTO reportRequestDTO,
			@PathVariable("id") Long id) {
		service.register(reportRequestDTO, id);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta o relatório registrado", description = "Deleta o relatório registrado com bose no ID")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.delete(id);

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Busca o relatório", description = "Busca o relatório com bose no ID fornecido")
	public ResponseEntity<ReportResponseDTO> find(@PathVariable("id") Long id) {
		Report report = service.findById(id);

		return ResponseEntity.ok().body(new ReportResponseDTO(report));
	}

	@GetMapping
	@Operation(summary = "Busca todos os relatórios", description = "Buscos todos os relatórios registrados no DB")
	public ResponseEntity<List<ReportResponseDTO>> findAll() {
		List<Report> reports = service.findAll();
		List<ReportResponseDTO> reportDTOs = reports.stream().map(x -> new ReportResponseDTO(x))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(reportDTOs);
	}

}
