package com.fiap.fiapburger.pedido.application.ports.out;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;

public interface BuscarPedidoOutputPort {

    PedidoResponse buscar (Pedido pedido);
}
