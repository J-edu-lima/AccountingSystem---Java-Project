package com.j_edulima.accouting.model.valueObject;

import java.util.regex.Pattern;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Embeddable;

@Embeddable
public class Password {
	private static final String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

	private String password;

	protected Password() {
	}

	public Password(String password) {
		if (validatePassword(password)) {
			this.password = password;
		}
	}

	private boolean validatePassword(String password) {
		if (Pattern.matches(regex, password)) {
			return true;
		}
		throw new IllegalArgumentException("Senha inválida");
	}

	@Bean
	public String passwordEncoder(Password password) {
		String cryptPassword = new BCryptPasswordEncoder().encode(password.toString());
		return cryptPassword;
	}

	@Override
	public String toString() {
		return password;
	}
}
