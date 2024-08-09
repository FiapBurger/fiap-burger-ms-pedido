package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.fiapburger.pedido.application.core.domain.PedidoMessageDTO;
import com.fiap.fiapburger.pedido.application.ports.out.AtualizarStatusPedidoOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;

class AtualizarStatusPedidoUseCaseTest {

    @Mock
    private AtualizarStatusPedidoOutputPort outputPort;

    private AtualizarStatusPedidoUseCase useCase;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new AtualizarStatusPedidoUseCase(outputPort);
    }

    void atualizarStatusPedido_DeveChamarOutputPort() {
        PedidoMessageDTO pedido = new PedidoMessageDTO();
        useCase.atualizarStatusPedido(pedido);
        Mockito.verify(outputPort).atualizarStatusPedido(any());
    }
}
