package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.ports.out.AvaliarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.AvaliarPedidoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class AvaliarPedidoUseCaseTest {

    @Mock
    private AvaliarPedidoOutputPort outputPort;

    private AvaliarPedidoUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new AvaliarPedidoUseCase(outputPort);
    }

    @Test
    void avaliar_DeveChamarOutputPort() {
        AvaliarPedidoRequest pedidoRequest = new AvaliarPedidoRequest();

        useCase.avaliar(pedidoRequest);

        Mockito.verify(outputPort).avaliar(Mockito.any());
    }
}
