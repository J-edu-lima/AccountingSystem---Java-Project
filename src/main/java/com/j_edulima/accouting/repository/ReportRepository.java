package com.j_edulima.accouting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j_edulima.accouting.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

}
