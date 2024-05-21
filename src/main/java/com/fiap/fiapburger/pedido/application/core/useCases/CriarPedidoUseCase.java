package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.core.domain.Produto;
import com.fiap.fiapburger.pedido.application.core.domain.enums.StatusPedido;
import com.fiap.fiapburger.pedido.application.ports.in.CriarPedidoInputPort;
import com.fiap.fiapburger.pedido.application.ports.out.CriarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.CriarPedidoRequest;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.PedidoMapperEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CriarPedidoUseCase implements CriarPedidoInputPort {

    private final CriarPedidoOutputPort criarPedidoOutputPort;

    private final PedidoMapperEntity pedidoMapperEntity;

    public CriarPedidoUseCase(CriarPedidoOutputPort criarPedidoOutputPort, PedidoMapperEntity pedidoMapperEntity) {
        this.criarPedidoOutputPort = criarPedidoOutputPort;
        this.pedidoMapperEntity = pedidoMapperEntity;
    }

    @Override
    public PedidoResponse criarPedido(CriarPedidoRequest criarPedidoRequest) {

        Pedido pedido = PedidoMapper.criarPedido(criarPedidoRequest);
        Date date = new Date(System.currentTimeMillis());

        pedido.setIdStatus(String.valueOf(StatusPedido.PEDIDO_CRIADO.getId()));
        pedido.setValorTotal(calcularValorTotal(criarPedidoRequest.getItensPedido()));
        pedido.setDataHoraInicio(date);
        pedido.setIdPagamento("0");
        pedido.setIdSatisfacao("0");
        PedidoEntity pedidoCriado = criarPedidoOutputPort.criarPedido(pedido);
        PedidoResponse pedidoResponse  = pedidoMapperEntity.toPedidoResponse(pedidoCriado);



        return pedidoResponse;
    }

    private BigDecimal calcularValorTotal(List<Produto> produtos) {
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (Produto produto : produtos) {
            valorTotal = valorTotal.add(produto.getPreco());
        }
        return valorTotal;
    }

}
