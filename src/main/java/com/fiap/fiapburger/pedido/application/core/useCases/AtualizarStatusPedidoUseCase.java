package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.fiapburger.pedido.application.core.domain.PedidoMessageDTO;
import com.fiap.fiapburger.pedido.application.ports.in.AtualizarStatusPedidoInputPort;
import com.fiap.fiapburger.pedido.application.ports.out.AtualizarStatusPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class AtualizarStatusPedidoUseCase implements AtualizarStatusPedidoInputPort {

    private final AtualizarStatusPedidoOutputPort atualizarStatusPedidoOutputPort;

    @Autowired
    private ObjectMapper objectMapper;

    public AtualizarStatusPedidoUseCase(AtualizarStatusPedidoOutputPort atualizarStatusPedidoOutputPort) {
        this.atualizarStatusPedidoOutputPort = atualizarStatusPedidoOutputPort;
    }


    @Override
    public void atualizarStatusPedido(PedidoMessageDTO pedido) {
        String jsonMessage;
        System.out.println(pedido.getIdStatus());
        try {
            jsonMessage = objectMapper.writeValueAsString(pedido);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao serializar mensagem", e);
        }
        atualizarStatusPedidoOutputPort.atualizarStatusPedido(jsonMessage);
    }
}
