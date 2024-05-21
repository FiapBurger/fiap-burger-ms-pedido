package com.fiap.fiapburger.pedido.application.ports.in;

import com.fiap.fiapburger.pedido.infrastructure.api.requests.AvaliarPedidoRequest;

public interface AvaliarPedidoInputPort {
    void avaliar(AvaliarPedidoRequest pedido);
}
