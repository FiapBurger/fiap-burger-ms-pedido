package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.core.exceptions.ExceptionsMessageEnum;
import com.fiap.fiapburger.pedido.application.core.exceptions.PedidoNaoEncontradoException;
import com.fiap.fiapburger.pedido.application.ports.out.DeletarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletarPedidoAdapter implements DeletarPedidoOutputPort {

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public void deletar(String idPedido) {
       PedidoEntity pedido = pedidoRepository.findById(idPedido)
               .orElseThrow(() -> new PedidoNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value()));

       pedidoRepository.delete(pedido);
    }

}

