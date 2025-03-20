package com.j_edulima.accouting.model.valueObject;

import java.util.regex.Pattern;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
	private static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	private static final Pattern pattern = Pattern.compile(regex);
	
	@Column(name = "email_value", unique = true)
	private String value;

	protected Email() {
	}

	public Email(String value) {
		if (validateEmail(value)) {
			this.value = value;
		}
	}

	private boolean validateEmail(String email) {
		if (email != null && pattern.matcher(email).matches()) {
			return true;
		}
		throw new IllegalArgumentException("Email inválido");
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
