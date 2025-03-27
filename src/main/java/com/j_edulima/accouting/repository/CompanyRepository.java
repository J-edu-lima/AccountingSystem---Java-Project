package com.j_edulima.accouting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j_edulima.accouting.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
