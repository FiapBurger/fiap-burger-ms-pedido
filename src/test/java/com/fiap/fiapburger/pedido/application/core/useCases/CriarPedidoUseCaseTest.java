package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.core.domain.ItensPedido;
import com.fiap.fiapburger.pedido.application.ports.out.CriarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.CriarPedidoRequest;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.PedidoMapperEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

class CriarPedidoUseCaseTest {

    @Mock
    private CriarPedidoOutputPort outputPort;

    @Mock
    private PedidoMapperEntity pedidoMapperEntity;

    private CriarPedidoUseCase useCase;

    @Mock
    private GerarSenhaUseCase gerarSenhaUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new CriarPedidoUseCase(outputPort, pedidoMapperEntity,gerarSenhaUseCase);
    }

    @Test
    void criarPedido_DeveRetornarPedidoResponseCorreto() {
        CriarPedidoRequest pedidoRequest = new CriarPedidoRequest();
        List<ItensPedido> itensPedidos = new ArrayList<>();
        ItensPedido itensPedido1 = new ItensPedido();
        itensPedido1.setPreco(BigDecimal.valueOf(10));
        itensPedidos.add(itensPedido1);
        pedidoRequest.setItensPedido(itensPedidos);

        PedidoEntity pedidoCriado = new PedidoEntity();
        PedidoResponse pedidoResponseEsperado = new PedidoResponse();

        Mockito.when(outputPort.criarPedido(any())).thenReturn(pedidoCriado);
        Mockito.when(pedidoMapperEntity.toPedidoResponse(any())).thenReturn(pedidoResponseEsperado);

        PedidoResponse resultado = useCase.criarPedido(pedidoRequest);

        assertEquals(pedidoResponseEsperado, resultado);
    }
}
