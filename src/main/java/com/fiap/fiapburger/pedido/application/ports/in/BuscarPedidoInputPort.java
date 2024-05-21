package com.fiap.fiapburger.pedido.application.ports.in;

import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;

public interface BuscarPedidoInputPort {
    PedidoResponse buscaPedido(String idPedido);
}
