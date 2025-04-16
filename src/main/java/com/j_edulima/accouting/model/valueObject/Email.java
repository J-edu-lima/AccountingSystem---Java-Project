package com.j_edulima.accouting.model.valueObject;

import java.util.regex.Pattern;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
	private static final String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	private static final Pattern pattern = Pattern.compile(regex);
	
	@Column(name = "email_value", unique = true)
	private String email;

	protected Email() {
	}

	public Email(String email) {
		if (validateEmail(email)) {
			this.email = email;
		}
	}

	private boolean validateEmail(String email) {
		if (email != null && pattern.matcher(email).matches()) {
			return true;
		}
		throw new RuntimeException("Formato do Email inválido");
	}

	public String getValue() {
		return email;
	}

	@Override
	public String toString() {
		return email;
	}
}
