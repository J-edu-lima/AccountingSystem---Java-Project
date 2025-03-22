package com.j_edulima.accouting.handler;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(Object id) {
		super("OBJETO NÃO ENCONTRADO - ID: " + id);
	}
}
