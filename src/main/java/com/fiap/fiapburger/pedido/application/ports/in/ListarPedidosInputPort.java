package com.fiap.fiapburger.pedido.application.ports.in;

import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;

import java.util.List;

public interface ListarPedidosInputPort {
    List<PedidoResponse> listaPedidos();

    List<PedidoResponse> listaPedidosPorStatus(String id_status);
}
