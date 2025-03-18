package com.j_edulima.accouting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j_edulima.accouting.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
