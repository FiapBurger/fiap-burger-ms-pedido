package com.fiap.fiapburger.pedido.application.core.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public ClienteNaoEncontradoException(String exception) {
		super(exception);
	}
}
