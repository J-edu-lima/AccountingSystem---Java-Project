package com.j_edulima.accouting.handler;

public class InvalidPasswordException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException() {
		super("A senha deve ter no mínimo 8 caracteres, incluindo uma letra maiúscula, um número e um caractere especial.");
	}
}
