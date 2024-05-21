package com.fiap.fiapburger.pedido.application.ports.out;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;

public interface CriarPedidoOutputPort {
    PedidoEntity criarPedido(Pedido pedido);
}
