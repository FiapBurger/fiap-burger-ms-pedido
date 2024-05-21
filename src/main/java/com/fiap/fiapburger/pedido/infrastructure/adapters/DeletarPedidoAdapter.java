package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.ports.out.DeletarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletarPedidoAdapter implements DeletarPedidoOutputPort {

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public void deletar(String idPedido) {
        pedidoRepository.findById(idPedido).ifPresent(
                pedido -> pedidoRepository.delete(pedido)
        );
    }

}

