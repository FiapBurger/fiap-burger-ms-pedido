package com.fiap.fiapburger.pedido.application.ports.out;

import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import java.util.List;

public interface ListarPedidosOutputPort {
    List<PedidoResponse> listaPedidos();
    List<PedidoResponse> listaPedidosPorStatus(String id_status);
}
