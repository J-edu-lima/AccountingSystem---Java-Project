package com.j_edulima.accouting.model;

import java.math.BigDecimal;

import com.j_edulima.accouting.model.enums.EntryType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private BigDecimal entry;

	@Enumerated
	private EntryType type;

	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	protected Transaction() {
	}

	public Transaction(BigDecimal entry, EntryType type) {
		super();
		this.entry = entry;
		this.type = type;
	}

	public double getValorAjustado() {
		return entry.doubleValue() * type.getFactor();
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getEntry() {
		return entry;
	}

	public EntryType getType() {
		return type;
	}

}
