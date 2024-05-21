package com.fiap.fiapburger.pedido.application.ports.in;

import com.fiap.fiapburger.pedido.infrastructure.api.requests.CriarPedidoRequest;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;

public interface CriarPedidoInputPort {
    PedidoResponse criarPedido(CriarPedidoRequest itensPedido);

}
