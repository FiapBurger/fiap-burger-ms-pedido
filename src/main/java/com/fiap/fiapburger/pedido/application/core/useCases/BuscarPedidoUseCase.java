package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.ports.in.BuscarPedidoInputPort;
import com.fiap.fiapburger.pedido.application.ports.out.BuscarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;

public class BuscarPedidoUseCase implements BuscarPedidoInputPort {
    private final BuscarPedidoOutputPort buscarPedidoOutputPort;
    public BuscarPedidoUseCase(BuscarPedidoOutputPort buscarPedidoOutputPort) {
        this.buscarPedidoOutputPort = buscarPedidoOutputPort;
    }
    @Override
    public PedidoResponse buscaPedido(String idPedido) {
        Pedido pedido = new Pedido();
        pedido.setId(idPedido);
        return this.buscarPedidoOutputPort.buscar(pedido);
    }
}

