package com.j_edulima.accouting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import com.j_edulima.accouting.model.User;

public interface UserRegisterRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.email.value = :email")
	UserDetails findByEmail(@Param("email") String email);
}
