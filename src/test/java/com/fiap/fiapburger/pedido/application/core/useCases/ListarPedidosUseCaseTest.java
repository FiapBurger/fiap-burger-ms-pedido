package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.ports.out.ListarPedidosOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListarPedidosUseCaseTest {

    @Mock
    private ListarPedidosOutputPort outputPort;

    private ListarPedidosUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new ListarPedidosUseCase(outputPort);
    }

    @Test
    void listaPedidos_DeveRetornarListaCorreta() {
        List<PedidoResponse> pedidosEsperados = new ArrayList<>();

        Mockito.when(outputPort.listaPedidos()).thenReturn(pedidosEsperados);

        List<PedidoResponse> resultado = useCase.listaPedidos();
        assertEquals(pedidosEsperados, resultado);
    }

    @Test
    void listaPedidosPorStatus_DeveRetornarListaCorreta() {
        String idStatus = "123";
        List<PedidoResponse> pedidosEsperados = new ArrayList<>();

        Mockito.when(outputPort.listaPedidosPorStatus(idStatus)).thenReturn(pedidosEsperados);
        List<PedidoResponse> resultado = useCase.listaPedidosPorStatus(idStatus);

        assertEquals(pedidosEsperados, resultado);
    }
}
