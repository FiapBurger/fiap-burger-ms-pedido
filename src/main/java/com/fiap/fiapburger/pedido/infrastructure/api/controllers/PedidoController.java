package com.fiap.fiapburger.pedido.infrastructure.api.controllers;

import com.fiap.fiapburger.pedido.application.ports.in.*;
import com.fiap.fiapburger.pedido.infrastructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.*;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final CriarPedidoInputPort criarPedidoInputPort;
    private final BuscarPedidoInputPort buscarPedidoInputPort;
    private final DeletarPedidoInputPort deletarPedidoInputPort;
    private final AvaliarPedidoInputPort avaliarPedidoInputPort;
    private final ListarPedidosInputPort listarPedidosInputPort;
    private final AtualizarStatusPedidoInputPort atualizarStatusPedidoInputPort;

    @Autowired
    public PedidoController(CriarPedidoInputPort criarPedidoInputPort, BuscarPedidoInputPort buscarPedidoInputPort, DeletarPedidoInputPort deletarPedidoInputPort, AvaliarPedidoInputPort avaliarPedidoInputPort, ListarPedidosInputPort listarPedidosInputPort, AtualizarStatusPedidoInputPort atualizarStatusPedidoInputPort) {
        this.criarPedidoInputPort = criarPedidoInputPort;
        this.buscarPedidoInputPort = buscarPedidoInputPort;
        this.deletarPedidoInputPort = deletarPedidoInputPort;
        this.avaliarPedidoInputPort = avaliarPedidoInputPort;
        this.listarPedidosInputPort = listarPedidosInputPort;
        this.atualizarStatusPedidoInputPort = atualizarStatusPedidoInputPort;
    }


    @PostMapping()
    @ResponseBody
    public ResponseEntity<PedidoResponse> criarPedido(@Valid @RequestBody CriarPedidoRequest criarPedidoRequest){
        PedidoResponse response = criarPedidoInputPort.criarPedido(criarPedidoRequest);
        return ResponseEntity.ok(response);
    };


    @PostMapping("/avaliar")
    public ResponseEntity<String> avaliarPedido(@Valid @RequestBody AvaliarPedidoRequest avaliarPedidoRequest){
        avaliarPedidoInputPort.avaliar(avaliarPedidoRequest);
        return ResponseEntity.ok("Pedido avaliado com sucesso!");
    };

    @DeleteMapping()
    public ResponseEntity<String> deletar(@Valid @RequestBody DeletarPedidoRequest deletarPedidoRequest){
        deletarPedidoInputPort.deletar(deletarPedidoRequest);
        return ResponseEntity.ok("pedido deletado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscar(@PathVariable String id){
        PedidoResponse pedido = buscarPedidoInputPort.buscaPedido(id);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping()
    public ResponseEntity<List<PedidoResponse>> listaPedidos(){
        List<PedidoResponse> pedidos = listarPedidosInputPort.listaPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/listar/{id_status}")
    public ResponseEntity<List<PedidoResponse>> listaPedidosPorStatus(@PathVariable String id_status){
        List<PedidoResponse> pedidos = listarPedidosInputPort.listaPedidosPorStatus(id_status);
        return ResponseEntity.ok(pedidos);
    }

    @PatchMapping("/atualizar-status")
    public ResponseEntity<String> atualizarStatusPedido(@Valid @RequestBody AtualizarStatusPedidoRequest atualizarStatusPedidoRequest){
        atualizarStatusPedidoInputPort.atualizarStatusPedido(PedidoMapper.atualizarStatusPedido(atualizarStatusPedidoRequest));
        return ResponseEntity.ok("Status do pedido atualizado com sucesso!");
    };

    @PostMapping("/efetuar-pagamento")
    public ResponseEntity<PedidoResponse> efetuarPagamento(@Valid @RequestBody EfetuarPagamentoRequest efetuarPagamentoRequest){
        PedidoResponse pedidoResponse = new PedidoResponse();
        pedidoResponse.setId(efetuarPagamentoRequest.getIdPedido());
        pedidoResponse.setIdPagamento("3");
        pedidoResponse.setIdStatus("2");
        pedidoResponse.setDetalhes("Pagamento efetuado com sucesso!");

        return ResponseEntity.ok(pedidoResponse);
    }
}
