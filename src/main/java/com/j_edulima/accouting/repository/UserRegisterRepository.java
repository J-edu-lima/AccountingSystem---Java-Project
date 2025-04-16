package com.j_edulima.accouting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.j_edulima.accouting.model.User;

public interface UserRegisterRepository extends JpaRepository<User, Long> {

	UserDetails findByUsername(String username);
}
