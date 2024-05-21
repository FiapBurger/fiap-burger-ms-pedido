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
        Pedido pedido = new Pedido();
        pedido.setId("1");

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId("1");

        PedidoResponse pedidoResponseEsperado = new PedidoResponse();

        when(pedidoRepository.findById("1")).thenReturn(Optional.of(pedidoEntity));
        when(pedidoMapper.toPedidoResponse(any())).thenReturn(pedidoResponseEsperado);

        PedidoResponse resultado = adapter.buscar(pedido);

        assertEquals(pedidoResponseEsperado, resultado);
    }

    @Test
    void buscar_DeveLancarExcecaoQuandoPedidoNaoExistir() {
        Pedido pedido = new Pedido();
        pedido.setId("1");

        when(pedidoRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(PedidoNaoEncontradoException.class, () -> adapter.buscar(pedido));
    }
}
