package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.ports.out.DeletarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.DeletarPedidoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class DeletarPedidoUseCaseTest {

    @Mock
    private DeletarPedidoOutputPort outputPort;

    private DeletarPedidoUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new DeletarPedidoUseCase(outputPort);
    }

    @Test
    void deletar_DeveChamarOutputPort() {
        DeletarPedidoRequest pedidoRequest = new DeletarPedidoRequest();
        pedidoRequest.setIdPedido("123");
        useCase.deletar(pedidoRequest);
        Mockito.verify(outputPort).deletar("123");
    }
}
