package com.fiap.fiapburger.pedido.infrastructure.api.mappers;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.core.domain.enums.StatusPedido;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.*;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.ItensPedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import org.mapstruct.Mapper;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    static public PedidoResponse toPedidoResponse(PedidoEntity pedidoEntity) {

        PedidoResponse pedidoResponse = new PedidoResponse();
        pedidoResponse.setId(pedidoEntity.getId());
        pedidoResponse.setValorTotal(pedidoEntity.getValorTotal());
        pedidoResponse.setDetalhes(pedidoEntity.getDetalhes());
        List<ItensPedidoResponse> itensPedido = new ArrayList<>();

        pedidoEntity.getItensPedido().forEach(item -> {
            ItensPedidoResponse itens = new ItensPedidoResponse();
            itens.setId(item.getId());
            itens.setNome(item.getNome());
            itens.setCategoria(item.getCategoria());
            itens.setDescricao(item.getDescricao());
            itens.setPreco(item.getPreco());
            itens.setIdPedido(item.getPedido().getId());
            itensPedido.add(itens);
        });

        pedidoResponse.setItensPedido(itensPedido);
        pedidoResponse.setIdStatus( pedidoEntity.getIdStatus() );
        pedidoResponse.setCpf( pedidoEntity.getCpf() );
        pedidoResponse.setDataHoraInicio( pedidoEntity.getDataHoraInicio() );
        pedidoResponse.setDataHoraFim( pedidoEntity.getDataHoraFim() );
        pedidoResponse.setIdPagamento( pedidoEntity.getIdPagamento() );
        pedidoResponse.setIdSatisfacao( pedidoEntity.getIdSatisfacao() );
        pedidoResponse.setSenha(pedidoEntity.getSenha());

        return pedidoResponse;
    }

    static public Pedido criarPedido(CriarPedidoRequest criarPedidoRequest) {
        Pedido pedido = new Pedido();
        pedido.setCpf(criarPedidoRequest.getCpf());
        pedido.setItensPedido(criarPedidoRequest.getItensPedido());
        pedido.setIdStatus(String.valueOf(StatusPedido.PEDIDO_CRIADO.getId()));
        pedido.setIdPagamento("0");
        pedido.setIdSatisfacao("0");

        return pedido;
    }


    static public Pedido avaliarPedido(AvaliarPedidoRequest avaliarPedidoRequest) {
        Pedido pedido = new Pedido();
        pedido.setId(avaliarPedidoRequest.getIdPedido());
        pedido.setIdSatisfacao(avaliarPedidoRequest.getIdSatisfacao());
        return pedido;
    }


    static Pedido atualizarStatusPedido(AtualizarStatusPedidoRequest atualizarStatusPedidoRequest) {
        Pedido pedido = new Pedido();
        pedido.setIdStatus(atualizarStatusPedidoRequest.getIdStatus());
        pedido.setId(atualizarStatusPedidoRequest.getIdPedido());
        return pedido;
    }


}
