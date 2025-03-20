package com.j_edulima.accouting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j_edulima.accouting.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
