package com.fiap.fiapburger.pedido.infrastructure.api.mappers;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.*;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoResponse toPedidoResponse(PedidoEntity pedidoEntity);


    static public Pedido criarPedido(CriarPedidoRequest criarPedidoRequest) {
        Pedido pedido = new Pedido();
        pedido.setCpf(criarPedidoRequest.getCpf());
        pedido.setItensPedido(criarPedidoRequest.getItensPedido());

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
