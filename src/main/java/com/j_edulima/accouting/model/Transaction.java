package com.j_edulima.accouting.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.j_edulima.accouting.model.enums.EntryType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(precision = 10, scale = 2)
	private BigDecimal entryValue;

	@Enumerated(EnumType.STRING)
	private EntryType type;

	private LocalDateTime generationDate;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	protected Transaction() {
	}

	public Transaction(BigDecimal entryValue, EntryType type) {
		this.entryValue = adjustValueByType(entryValue, type);
		this.type = type;
	}

	public Transaction(BigDecimal entryValue, EntryType type, LocalDateTime generationDate, Company company) {
		this.entryValue = adjustValueByType(entryValue, type);
		this.type = type;
		this.generationDate = LocalDateTime.now();
		this.company = company;
	}

	private BigDecimal adjustValueByType(BigDecimal entryValue, EntryType type) {
		return entryValue.multiply(BigDecimal.valueOf(type.getFactor()));
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getValue() {
		return entryValue;
	}

	public EntryType getType() {
		return type;
	}

	public LocalDateTime getGenerationDate() {
		return generationDate;
	}

	public Company getCompany() {
		return company;
	}
}
