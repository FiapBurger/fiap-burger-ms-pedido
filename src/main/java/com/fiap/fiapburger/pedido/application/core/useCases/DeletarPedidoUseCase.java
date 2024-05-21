package com.fiap.fiapburger.pedido.application.core.useCases;


import com.fiap.fiapburger.pedido.application.ports.in.DeletarPedidoInputPort;
import com.fiap.fiapburger.pedido.application.ports.out.DeletarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.DeletarPedidoRequest;

public class DeletarPedidoUseCase implements DeletarPedidoInputPort {

    private DeletarPedidoOutputPort deletarPedidoOutputPort;

    public DeletarPedidoUseCase(DeletarPedidoOutputPort deletarPedidoOutputPort) {
        this.deletarPedidoOutputPort = deletarPedidoOutputPort;
    }

    @Override
    public void deletar(DeletarPedidoRequest deletarPedidoRequest) {
        deletarPedidoOutputPort.deletar(deletarPedidoRequest.getIdPedido());
    }

}
