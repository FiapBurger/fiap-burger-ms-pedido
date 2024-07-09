package com.fiap.fiapburger.pedido.infrastructure.persistence.mappers;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapperEntity {
    public PedidoEntity toPedidoEntity(Pedido pedido) {
        var pedidoEntity = new PedidoEntity();
        BeanUtils.copyProperties(pedido, pedidoEntity);

        return pedidoEntity;
    }

    public PedidoResponse toPedidoResponse(PedidoEntity pedido) {
        var pedidoResponse = new PedidoResponse();
        BeanUtils.copyProperties(pedido, pedidoResponse);
        return pedidoResponse;
    }
}
