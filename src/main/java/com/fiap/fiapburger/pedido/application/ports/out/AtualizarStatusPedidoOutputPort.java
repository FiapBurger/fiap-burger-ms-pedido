package com.fiap.fiapburger.pedido.application.ports.out;

import com.fiap.fiapburger.pedido.application.core.domain.PedidoMessageDTO;

public interface AtualizarStatusPedidoOutputPort {
    void atualizarStatusPedido(PedidoMessageDTO pedido);
}
