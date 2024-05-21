package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.ports.out.CriarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.PedidoEntityMapper;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.PedidoMapperEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CriarPedidoAdapter implements CriarPedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapperEntity pedidoEntityMapper;


    @Override
    public PedidoEntity criarPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoEntityMapper.toPedidoEntity(pedido);
        pedidoEntity = pedidoRepository.save(pedidoEntity);

        return pedidoEntity;
    }


}

