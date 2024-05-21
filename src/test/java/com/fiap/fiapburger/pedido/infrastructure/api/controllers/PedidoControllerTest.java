package com.fiap.fiapburger.pedido.infrastructure.api.controllers;

import com.fiap.fiapburger.pedido.application.ports.in.*;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.*;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PedidoControllerTest {

    @Mock
    private CriarPedidoInputPort criarPedidoInputPort;

    @Mock
    private AvaliarPedidoInputPort avaliarPedidoInputPort;

    @Mock
    private DeletarPedidoInputPort deletarPedidoInputPort;

    @Mock
    private BuscarPedidoInputPort buscarPedidoInputPort;

    @Mock
    private ListarPedidosInputPort listarPedidosInputPort;

    @Mock
    private AtualizarStatusPedidoInputPort atualizarStatusPedidoInputPort;

    @InjectMocks
    private PedidoController pedidoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarPedido() {
        CriarPedidoRequest request = new CriarPedidoRequest();
        PedidoResponse response = new PedidoResponse();
        when(criarPedidoInputPort.criarPedido(request)).thenReturn(response);

        ResponseEntity<PedidoResponse> result = pedidoController.criarPedido(request);

        assertEquals(response, result.getBody());
    }

    @Test
    public void testAvaliarPedido() {
        AvaliarPedidoRequest request = new AvaliarPedidoRequest();
        doNothing().when(avaliarPedidoInputPort).avaliar(request);

        ResponseEntity<String> result = pedidoController.avaliarPedido(request);

        assertEquals("Pedido avaliado com sucesso!", result.getBody());
    }

    @Test
    public void testDeletar() {
        DeletarPedidoRequest request = new DeletarPedidoRequest();
        doNothing().when(deletarPedidoInputPort).deletar(request);

        ResponseEntity<String> result = pedidoController.deletar(request);

        assertEquals("pedido deletado com sucesso!", result.getBody());
    }

    @Test
    public void testBuscar() {
        String id = "1";
        PedidoResponse response = new PedidoResponse();
        when(buscarPedidoInputPort.buscaPedido(id)).thenReturn(response);

        ResponseEntity<PedidoResponse> result = pedidoController.buscar(id);

        assertEquals(response, result.getBody());
    }

    @Test
    public void testListaPedidos() {
        List<PedidoResponse> response = new ArrayList<>();
        when(listarPedidosInputPort.listaPedidos()).thenReturn(response);

        ResponseEntity<List<PedidoResponse>> result = pedidoController.listaPedidos();

        assertEquals(response, result.getBody());
    }

    @Test
    public void testListaPedidosPorStatus() {
        String idStatus = "1";
        List<PedidoResponse> response = new ArrayList<>();
        when(listarPedidosInputPort.listaPedidosPorStatus(idStatus)).thenReturn(response);

        ResponseEntity<List<PedidoResponse>> result = pedidoController.listaPedidosPorStatus(idStatus);

        assertEquals(response, result.getBody());
    }

    @Test
    public void testEfetuarPagamento() {
        EfetuarPagamentoRequest request = new EfetuarPagamentoRequest();

        ResponseEntity<PedidoResponse> result = pedidoController.efetuarPagamento(request);

        assertEquals("3", result.getBody().getIdPagamento());
        assertEquals("2", result.getBody().getIdStatus());
        assertEquals("Pagamento efetuado com sucesso!", result.getBody().getDetalhes());
        assertEquals(BigDecimal.valueOf(22), result.getBody().getValorTotal());
    }
}
