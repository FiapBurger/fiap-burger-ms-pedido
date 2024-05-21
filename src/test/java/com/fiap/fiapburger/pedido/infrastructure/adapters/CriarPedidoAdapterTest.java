package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.PedidoEntityMapper;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.PedidoMapperEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CriarPedidoAdapterTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private PedidoMapperEntity pedidoEntityMapper;

    @InjectMocks
    private CriarPedidoAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarPedido_DeveCriarPedidoCorretamente() {
        Pedido pedido = new Pedido();

        PedidoEntity pedidoEntity = new PedidoEntity();

        when(pedidoEntityMapper.toPedidoEntity(any())).thenReturn(pedidoEntity);
        when(pedidoRepository.save(any())).thenReturn(pedidoEntity);
        PedidoEntity resultado = adapter.criarPedido(pedido);

        assertEquals(pedidoEntity, resultado);
    }
}
