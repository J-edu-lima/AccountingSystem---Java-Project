package com.j_edulima.accouting.handler;

public class DataErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataErrorException() {
		super("DADOS INCORRETOS");
	}
}
