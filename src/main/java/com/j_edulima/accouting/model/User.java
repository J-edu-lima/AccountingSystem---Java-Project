package com.j_edulima.accouting.model;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.j_edulima.accouting.model.enums.UserRole;
import com.j_edulima.accouting.model.valueObject.Email;
import com.j_edulima.accouting.model.valueObject.Password;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Nullable
	private String username;

	@Embedded
	private Email email;

	@Embedded
	private Password password;

	@Enumerated
	private UserRole role;

	@JsonIgnore
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Company company;

	public User() {
	}

	public User(String username, UserRole role) {
		this.username = username;
		this.role = role;
	}

	public User(String username, Email email, Password password, UserRole role) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password.toString();
	}

	@Override
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email.toString();
	}

	public UserRole getRole() {
		return role;
	}

	public Company getCompany() {
		return company;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
