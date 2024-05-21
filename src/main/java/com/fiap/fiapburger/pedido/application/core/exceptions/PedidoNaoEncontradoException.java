package com.fiap.fiapburger.pedido.application.core.exceptions;

import java.io.Serial;

public class PedidoNaoEncontradoException extends RuntimeException{


    @Serial
    private static final long serialVersionUID = -7583046868678964928L;

    public PedidoNaoEncontradoException(String exception) {
        super(exception);
    }
}