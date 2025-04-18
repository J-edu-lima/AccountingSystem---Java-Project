package com.j_edulima.accouting.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.j_edulima.accouting.model.valueObject.Name;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Embedded
	private Name name;

	@OneToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private User user;

	@JsonIgnore
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transaction> transactions = new ArrayList<>();

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Report> reports = new ArrayList<>();

	protected Company() {
	}

	public Company(Name name, User user) {
		this.name = name;
		this.user = user;
	}

	public Company(Name name, User user, List<Transaction> transactions, List<Report> reports) {
		this.name = name;
		this.user = user;
		this.transactions = transactions;
		this.reports = reports;
	}

	public void addEntry(Transaction entry) {
		transactions.add(entry);
	}

	public void addReport(Report report) {
		reports.add(report);
	}

	public Long getId() {
		return id;
	}

	public Name getName() {
		return name;
	}

	public String getUser() {
		return user.getId().toString();
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public List<Report> getReports() {
		return reports;
	}

}
