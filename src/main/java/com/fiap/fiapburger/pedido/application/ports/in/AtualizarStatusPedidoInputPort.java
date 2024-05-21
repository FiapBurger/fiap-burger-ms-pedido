package com.fiap.fiapburger.pedido.application.ports.in;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;

public interface AtualizarStatusPedidoInputPort {
    void atualizarStatusPedido(Pedido pedido);
}
