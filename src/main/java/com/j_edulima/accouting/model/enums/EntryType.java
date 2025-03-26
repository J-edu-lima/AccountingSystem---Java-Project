package com.j_edulima.accouting.model.enums;

public enum EntryType {

	GAIN(1), EXPENSE(-1);

	private final int factor;

	EntryType(int factor) {
		this.factor = factor;
	}

	public int getFactor() {
		return factor;
	}
}
