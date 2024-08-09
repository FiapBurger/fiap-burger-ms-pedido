package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.fiapburger.pedido.application.core.domain.PedidoMessageDTO;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.JpaPedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AtualizarStatusPedidoAdapterTest {

    @Mock
    private JpaPedidoRepository jpaPedidoRepository;

    @InjectMocks
    private AtualizarStatusPedidoAdapter adapter;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void atualizarStatusPedido_DeveLancarExcecaoQuandoPagamentoNaoRealizado() {
        PedidoMessageDTO pedido = new PedidoMessageDTO();
        pedido.setId("1");
        pedido.setIdStatus("6");
        pedido.setIdPagamento("0");

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId("1");
        pedidoEntity.setIdStatus("5");
        pedidoEntity.setIdPagamento("0");

        when(jpaPedidoRepository.findById("1")).thenReturn(Optional.of(pedidoEntity));

        String jsonMessage;
        try {
            jsonMessage = objectMapper.writeValueAsString(pedido);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao serializar mensagem", e);
        }

        assertThrows(RuntimeException.class, () -> adapter.atualizarStatusPedido(jsonMessage));
    }

    @Test
    void atualizarStatusPedido_DeveLancarExcecaoQuandoPedidoNaoExistir() {
        PedidoMessageDTO pedido = new PedidoMessageDTO();
        pedido.setId("1");
        pedido.setIdStatus("6");
        pedido.setIdPagamento("1");

        when(jpaPedidoRepository.findById("1")).thenReturn(Optional.empty());

        String jsonMessage;
        try {
            jsonMessage = objectMapper.writeValueAsString(pedido);
            System.out.println("jsonMessage: " + jsonMessage);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao serializar mensagem", e);
        }

        assertThrows(RuntimeException.class, () -> adapter.atualizarStatusPedido(jsonMessage));
    }
}
