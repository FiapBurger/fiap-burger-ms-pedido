package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.ports.out.BuscarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class BuscarPedidoUseCaseTest {

    @Mock
    private BuscarPedidoOutputPort outputPort;

    private BuscarPedidoUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new BuscarPedidoUseCase(outputPort);
    }

    @Test
    void buscaPedido_DeveChamarOutputPort() {
        String idPedido = "123";
        PedidoResponse pedidoResponse = new PedidoResponse();

        Mockito.when(outputPort.buscar(Mockito.any())).thenReturn(pedidoResponse);
        PedidoResponse result = useCase.buscaPedido(idPedido);

        Mockito.verify(outputPort).buscar(Mockito.any());
    }
}
