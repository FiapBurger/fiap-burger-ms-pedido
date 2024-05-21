package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.ports.out.AtualizarStatusPedidoOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class AtualizarStatusPedidoUseCaseTest {

    @Mock
    private AtualizarStatusPedidoOutputPort outputPort;

    private AtualizarStatusPedidoUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new AtualizarStatusPedidoUseCase(outputPort);
    }

    @Test
    void atualizarStatusPedido_DeveChamarOutputPort() {
        Pedido pedido = new Pedido();
        useCase.atualizarStatusPedido(pedido);
        Mockito.verify(outputPort).atualizarStatusPedido(pedido);
    }
}
