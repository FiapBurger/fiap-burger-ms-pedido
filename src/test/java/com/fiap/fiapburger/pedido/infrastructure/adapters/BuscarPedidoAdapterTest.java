package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.core.exceptions.ExceptionsMessageEnum;
import com.fiap.fiapburger.pedido.application.core.exceptions.PedidoNaoEncontradoException;
import com.fiap.fiapburger.pedido.infrastructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.StatusMapper;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BuscarPedidoAdapterTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private PedidoMapper pedidoMapper;

    @Mock
    private StatusMapper statusMapper;

    @InjectMocks
    private BuscarPedidoAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscar_DeveRetornarPedidoResponseCorretoQuandoPedidoExistir() {
        // Arrange
        Pedido pedido = new Pedido();
        pedido.setId("1");

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdPedido("1");

        PedidoResponse pedidoResponseEsperado = new PedidoResponse();
        // Configure o pedidoResponseEsperado conforme necessário

        when(pedidoRepository.findById("1")).thenReturn(Optional.of(pedidoEntity));
        when(pedidoMapper.toPedidoResponse(any())).thenReturn(pedidoResponseEsperado);

        // Act
        PedidoResponse resultado = adapter.buscar(pedido);

        // Assert
        assertEquals(pedidoResponseEsperado, resultado);
    }

    @Test
    void buscar_DeveLancarExcecaoQuandoPedidoNaoExistir() {
        // Arrange
        Pedido pedido = new Pedido();
        pedido.setId("1");

        when(pedidoRepository.findById("1")).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(PedidoNaoEncontradoException.class, () -> adapter.buscar(pedido));
    }
}
