package com.j_edulima.accouting.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j_edulima.accouting.dto.CompanyRequestDTO;
import com.j_edulima.accouting.dto.CompanyResponseDTO;
import com.j_edulima.accouting.model.Company;
import com.j_edulima.accouting.service.CompanyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/v1/companys")
@Tag(name = "companys", description = "Gerenciamento de empresas")
public class CompanyController {

	@Autowired
	private CompanyService service;

	@PostMapping("/{id}")
	@Operation(summary = "", description = "")
	public ResponseEntity<Void> register(@RequestBody CompanyRequestDTO companyRequestDTO,
			@PathVariable("id") Long id) {
		service.register(companyRequestDTO, id);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	@Operation(summary = "", description = "")
	public ResponseEntity<List<CompanyResponseDTO>> findAll() {
		List<Company> companys = service.findAll();
		List<CompanyResponseDTO> companyDTOs = companys.stream().map(x -> new CompanyResponseDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(companyDTOs);
	}

}
