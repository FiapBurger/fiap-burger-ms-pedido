package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.ports.in.ListarPedidosInputPort;
import com.fiap.fiapburger.pedido.application.ports.out.ListarPedidosOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;

import java.util.List;

public class ListarPedidosUseCase implements ListarPedidosInputPort {

    private final ListarPedidosOutputPort listarPedidosOutputPort;

    public ListarPedidosUseCase(ListarPedidosOutputPort listarPedidosOutputPort) {
        this.listarPedidosOutputPort = listarPedidosOutputPort;
    }

    @Override
    public List<PedidoResponse> listaPedidos() {
        return this.listarPedidosOutputPort.listaPedidos();
    }

    @Override
    public List<PedidoResponse> listaPedidosPorStatus(String id_status) {
        return this.listarPedidosOutputPort.listaPedidosPorStatus(id_status);
    }
}
