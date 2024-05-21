package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.ports.in.AtualizarStatusPedidoInputPort;
import com.fiap.fiapburger.pedido.application.ports.out.AtualizarStatusPedidoOutputPort;

public class AtualizarStatusPedidoUseCase implements AtualizarStatusPedidoInputPort {

    private final AtualizarStatusPedidoOutputPort atualizarStatusPedidoOutputPort;

    public AtualizarStatusPedidoUseCase(AtualizarStatusPedidoOutputPort atualizarStatusPedidoOutputPort) {
        this.atualizarStatusPedidoOutputPort = atualizarStatusPedidoOutputPort;
    }


    @Override
    public void atualizarStatusPedido(Pedido pedido) {
        atualizarStatusPedidoOutputPort.atualizarStatusPedido(pedido);
    }
}
