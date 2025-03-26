package com.j_edulima.accouting.model.valueObject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Name {

	@Column(name = "name_value")
	private String value;
	
	protected Name() {
	}

	public Name(String value) {
		if (validateName(value)) {
			this.value = value;
		}
	}

	private boolean validateName(String name) {
		if (name != null) {
			return true;
		}
		throw new NullPointerException();
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}

