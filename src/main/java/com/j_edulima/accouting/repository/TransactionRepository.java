package com.j_edulima.accouting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j_edulima.accouting.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
