package com.fiap.fiapburger.pedido.application.ports.in;

import com.fiap.fiapburger.pedido.application.core.domain.PedidoMessageDTO;

public interface AtualizarStatusPedidoInputPort {
    void atualizarStatusPedido(PedidoMessageDTO pedido);
}
