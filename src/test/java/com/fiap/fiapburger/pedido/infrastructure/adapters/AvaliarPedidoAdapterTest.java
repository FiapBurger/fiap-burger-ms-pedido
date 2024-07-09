package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.core.exceptions.ClienteNaoEncontradoException;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.JpaPedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AvaliarPedidoAdapterTest {

    @Mock
    private JpaPedidoRepository jpaPedidoRepository;

    @InjectMocks
    private AvaliarPedidoAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void avaliar_DeveAvaliarPedidoQuandoPedidoExistir() {
        Pedido pedido = new Pedido();
        pedido.setId("1");
        pedido.setIdSatisfacao("5");

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId("1");

        when(jpaPedidoRepository.findById("1")).thenReturn(Optional.of(pedidoEntity));

        adapter.avaliar(pedido);

        verify(jpaPedidoRepository, times(1)).save(any());
    }

    @Test
    void avaliar_DeveLancarExcecaoQuandoPedidoNaoExistir() {
        Pedido pedido = new Pedido();
        pedido.setId("1");
        pedido.setIdSatisfacao("5");

        when(jpaPedidoRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(ClienteNaoEncontradoException.class, () -> adapter.avaliar(pedido));
    }
}
