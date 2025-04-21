package com.j_edulima.accouting.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.j_edulima.accouting.model.enums.ReportType;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_report")
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Enumerated
	private ReportType type;

	private LocalDateTime generationDate;

	private BigDecimal calculatedValue;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	protected Report() {
	}

	public Report(ReportType type, LocalDateTime generationDate, Company company, BigDecimal calculatedValue) {
		super();
		this.type = type;
		this.generationDate = LocalDateTime.now();
		this.company = company;
		this.calculatedValue = calculatedValue;
	}

	public Long getId() {
		return id;
	}

	public ReportType getType() {
		return type;
	}

	public LocalDateTime getGenerationDate() {
		return generationDate;
	}

	public BigDecimal getCalculatedValue() {
		return calculatedValue;
	}

	public Company getCompany() {
		return company;
	}
}
