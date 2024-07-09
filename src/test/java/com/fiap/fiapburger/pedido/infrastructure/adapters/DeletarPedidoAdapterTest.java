package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.core.exceptions.PedidoNaoEncontradoException;
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

class DeletarPedidoAdapterTest {

    @Mock
    private JpaPedidoRepository jpaPedidoRepository;

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

        when(jpaPedidoRepository.findById(idPedido)).thenReturn(Optional.of(pedidoEntity));

        adapter.deletar(idPedido);

        verify(jpaPedidoRepository, times(1)).delete(pedidoEntity);
    }

    @Test
    void deletar_NaoDeveDeletarPedidoInexistente() {
        String idPedido = "1";

        when(jpaPedidoRepository.findById(idPedido)).thenReturn(Optional.empty());

        assertThrows(PedidoNaoEncontradoException.class, () -> adapter.deletar(idPedido));

        verify(jpaPedidoRepository, never()).delete(any());
    }
}
