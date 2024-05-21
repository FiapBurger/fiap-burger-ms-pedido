package com.fiap.fiapburger.pedido.application.core.useCases;


import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.ports.in.AvaliarPedidoInputPort;
import com.fiap.fiapburger.pedido.application.ports.out.AvaliarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.AvaliarPedidoRequest;

public class AvaliarPedidoUseCase implements AvaliarPedidoInputPort {

    private final AvaliarPedidoOutputPort avaliarPedidoOutputPort;

    public AvaliarPedidoUseCase(AvaliarPedidoOutputPort avaliarPedidoOutputPort) {
        this.avaliarPedidoOutputPort = avaliarPedidoOutputPort;
    }

    @Override
    public void avaliar(AvaliarPedidoRequest pedidoRequest) {
        Pedido pedido = PedidoMapper.avaliarPedido(pedidoRequest);
        avaliarPedidoOutputPort.avaliar(pedido);
    }
}
