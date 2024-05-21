package com.fiap.fiapburger.pedido.application.ports.out;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;

public interface ConfirmarPedidoOutputPort {
    void confirmar(Pedido pedido);
}
