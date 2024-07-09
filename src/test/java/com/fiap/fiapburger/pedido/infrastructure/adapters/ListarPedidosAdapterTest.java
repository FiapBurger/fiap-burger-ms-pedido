package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.JpaPedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListarPedidosAdapterTest {

    private JpaPedidoRepository jpaPedidoRepository;
    private ListarPedidosAdapter listarPedidosAdapter;

    @BeforeEach
    void setUp() {
        jpaPedidoRepository = mock(JpaPedidoRepository.class);
        listarPedidosAdapter = new ListarPedidosAdapter(jpaPedidoRepository);
    }

    @Test
    @DisplayName("Deve retornar lista de pedidos corretamente")
    void listaPedidos_DeveRetornarListaDePedidosCorretamente() {
        PedidoEntity pedido1 = new PedidoEntity();
        pedido1.setId("1");
        pedido1.setIdStatus("1");
        pedido1.setDataHoraInicio(LocalDateTime.now());

        PedidoEntity pedido2 = new PedidoEntity();
        pedido2.setId("2");
        pedido2.setIdStatus("1");
        pedido2.setDataHoraInicio(LocalDateTime.now());

        List<PedidoEntity> pedidos = Arrays.asList(pedido1, pedido2);

        when(jpaPedidoRepository.findAll()).thenReturn(pedidos);

        List<PedidoResponse> resultado = listarPedidosAdapter.listaPedidos();
        assertEquals(pedidos.size(), resultado.size());
    }

    @Test
    @DisplayName("Deve retornar lista de pedidos por status corretamente")
    void listaPedidosPorStatus_DeveRetornarListaDePedidosPorStatusCorretamente() {

        PedidoEntity pedido1 = new PedidoEntity();
        pedido1.setId("1");
        pedido1.setIdStatus("1");
        pedido1.setDataHoraInicio(LocalDateTime.now());

        PedidoEntity pedido2 = new PedidoEntity();
        pedido2.setId("2");
        pedido2.setIdStatus("1");
        pedido2.setDataHoraInicio(LocalDateTime.now());

        List<PedidoEntity> pedidos = Arrays.asList(pedido1, pedido2);

        when(jpaPedidoRepository.findAll()).thenReturn(pedidos);

        List<PedidoResponse> resultado = listarPedidosAdapter.listaPedidosPorStatus("1");

        assertEquals(resultado.size(), 2);
    }
}
