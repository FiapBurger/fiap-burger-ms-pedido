package com.fiap.fiapburger.pedido.application.ports.in;

import com.fiap.fiapburger.pedido.infrastructure.api.requests.DeletarPedidoRequest;

public interface DeletarPedidoInputPort {
    void deletar(DeletarPedidoRequest itensPedidoRequest);
}
