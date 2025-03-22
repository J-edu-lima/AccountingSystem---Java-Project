package com.j_edulima.accouting.handler;

public class InvalidEmailException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidEmailException() {
		super("Formato do Email inválido");
	}
}
