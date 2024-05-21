package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.PedidoMapperEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListarPedidosAdapterTest {

    private PedidoRepository pedidoRepository;
    private PedidoMapperEntity pedidoMapperEntity;
    private ListarPedidosAdapter listarPedidosAdapter;

    @BeforeEach
    void setUp() {
        pedidoRepository = mock(PedidoRepository.class);
        pedidoMapperEntity = mock(PedidoMapperEntity.class);
        listarPedidosAdapter = new ListarPedidosAdapter(pedidoRepository, pedidoMapperEntity);
    }

    @Test
    @DisplayName("Deve retornar lista de pedidos corretamente")
    void listaPedidos_DeveRetornarListaDePedidosCorretamente() {
        PedidoEntity pedido1 = new PedidoEntity();
        pedido1.setId("1");
        pedido1.setIdStatus("EM_ANDAMENTO");

        PedidoEntity pedido2 = new PedidoEntity();
        pedido2.setId("2");
        pedido2.setIdStatus(null);

        List<PedidoEntity> pedidos = Arrays.asList(pedido1, pedido2);


        when(pedidoRepository.findAll()).thenReturn(pedidos);


        PedidoResponse pedidoResponse1 = new PedidoResponse();
        pedidoResponse1.setId("1");
        pedidoResponse1.setIdStatus("EM_ANDAMENTO");

        PedidoResponse pedidoResponse2 = new PedidoResponse();
        pedidoResponse2.setId("2");
        pedidoResponse2.setIdStatus(null);

        when(pedidoMapperEntity.toPedidoResponse(pedido1)).thenReturn(pedidoResponse1);
        when(pedidoMapperEntity.toPedidoResponse(pedido2)).thenReturn(pedidoResponse2);
        List<PedidoResponse> resultado = listarPedidosAdapter.listaPedidos();
        assertEquals(null, resultado.get(0).getIdStatus());
    }

    @Test
    @DisplayName("Deve retornar lista de pedidos por status corretamente")
    void listaPedidosPorStatus_DeveRetornarListaDePedidosPorStatusCorretamente() {

        PedidoEntity pedido1 = new PedidoEntity();
        pedido1.setId("1");
        pedido1.setIdStatus("CONCLUIDO");

        PedidoEntity pedido2 = new PedidoEntity();
        pedido2.setId("2");
        pedido2.setIdStatus(null);

        List<PedidoEntity> pedidos = Arrays.asList(pedido1, pedido2);

        when(pedidoRepository.findAll()).thenReturn(pedidos);

        PedidoResponse pedidoResponse1 = new PedidoResponse();
        pedidoResponse1.setId("1");
        pedidoResponse1.setIdStatus("CONCLUIDO");

        PedidoResponse pedidoResponse2 = new PedidoResponse();
        pedidoResponse2.setId("2");
        pedidoResponse2.setIdStatus(null);

        when(pedidoMapperEntity.toPedidoResponse(pedido1)).thenReturn(pedidoResponse1);
        when(pedidoMapperEntity.toPedidoResponse(pedido2)).thenReturn(pedidoResponse2);

        List<PedidoResponse> resultado = listarPedidosAdapter.listaPedidosPorStatus("CONCLUIDO");

        assertEquals(null, resultado.get(0).getIdStatus());
    }
}
