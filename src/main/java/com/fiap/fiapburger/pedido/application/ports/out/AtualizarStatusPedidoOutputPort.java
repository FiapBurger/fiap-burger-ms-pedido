package com.fiap.fiapburger.pedido.application.ports.out;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;

public interface AtualizarStatusPedidoOutputPort {
    void atualizarStatusPedido(Pedido pedido);
}
