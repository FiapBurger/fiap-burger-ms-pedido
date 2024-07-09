package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.core.exceptions.PedidoNaoEncontradoException;
import com.fiap.fiapburger.pedido.infrastructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.ItensPedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.StatusMapper;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.JpaPedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BuscarPedidoAdapterTest {

    @Mock
    private JpaPedidoRepository jpaPedidoRepository;

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
        List<ItensPedidoEntity> itens = new ArrayList<>();
        ItensPedidoEntity itensPedido = new ItensPedidoEntity();
        itensPedido.setId("1");
        itensPedido.setPreco(BigDecimal.valueOf(10));
        itensPedido.setDescricao("teste");
        itensPedido.setPedido(pedidoEntity);
        itensPedido.setNome("item teste");
        itensPedido.setCategoria("item categoria");
        itens.add(itensPedido);
        pedidoEntity.setItensPedido(itens);

        when(jpaPedidoRepository.findById("1")).thenReturn(Optional.of(pedidoEntity));

        PedidoResponse resultado = adapter.buscar(pedido);

        assertEquals("1", resultado.getId());
    }

    @Test
    void buscar_DeveLancarExcecaoQuandoPedidoNaoExistir() {
        Pedido pedido = new Pedido();
        pedido.setId("1");

        when(jpaPedidoRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(PedidoNaoEncontradoException.class, () -> adapter.buscar(pedido));
    }
}
