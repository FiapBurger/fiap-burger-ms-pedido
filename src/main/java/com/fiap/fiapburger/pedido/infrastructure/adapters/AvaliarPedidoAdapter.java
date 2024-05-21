package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.core.exceptions.ClienteNaoEncontradoException;
import com.fiap.fiapburger.pedido.application.core.exceptions.ExceptionsMessageEnum;
import com.fiap.fiapburger.pedido.application.ports.out.AvaliarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class AvaliarPedidoAdapter implements AvaliarPedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void avaliar(Pedido pedido) {

        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(pedido.getId());
        if(pedidoEntity.isPresent()){
            pedidoEntity.get().setIdSatisfacao(pedido.getIdSatisfacao());
            pedidoRepository.save(pedidoEntity.get());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }
    }
}

