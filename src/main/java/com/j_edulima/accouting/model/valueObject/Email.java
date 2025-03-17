package com.j_edulima.accouting.model.valueObject;

import java.util.regex.Pattern;

import jakarta.persistence.Embeddable;

@Embeddable
public class Email {

	private static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	private static final Pattern pattern = Pattern.compile(regex);

	private String email;

	public Email(String email) {
		if (validateEmail(email)) {
			this.email = email;
		}
	}

	private boolean validateEmail(String email) {
		if (email != null && pattern.matcher(email).matches()) {
			return true;
		}
		throw new IllegalArgumentException("Email inválido");
	}

	@Override
	public String toString() {
		return email;
	}
}
