package com.j_edulima.accouting.model;

import java.util.ArrayList;
import java.util.List;

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
	
	private List<FinancialEntry> financialEntrys = new ArrayList<>();
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Report> reports = new ArrayList<>();

}
