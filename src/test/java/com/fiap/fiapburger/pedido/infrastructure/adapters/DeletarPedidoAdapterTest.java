package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DeletarPedidoAdapterTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private DeletarPedidoAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deletar_DeveDeletarPedidoExistente() {
        String idPedido = "1";
        PedidoEntity pedidoEntity = new PedidoEntity();

        when(pedidoRepository.findById(idPedido)).thenReturn(Optional.of(pedidoEntity));

        adapter.deletar(idPedido);

        verify(pedidoRepository, times(1)).delete(pedidoEntity);
    }

    @Test
    void deletar_NaoDeveDeletarPedidoInexistente() {
        String idPedido = "1";

        when(pedidoRepository.findById(idPedido)).thenReturn(Optional.empty());

        adapter.deletar(idPedido);

        verify(pedidoRepository, never()).delete(any());
    }
}
