package com.j_edulima.accouting.model.valueObject;

import java.util.regex.Pattern;

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
		return email != null && pattern.matcher(email).matches();
	}

	@Override
	public String toString() {
		return email;
	}
}
