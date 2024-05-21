package com.fiap.fiapburger.pedido.application.ports.out;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;

public interface AvaliarPedidoOutputPort {
    void avaliar(Pedido pedido);
}
