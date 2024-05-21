package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.ports.out.AtualizarStatusPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Objects;

@Component
public class AtualizarStatusPedidoAdapter implements AtualizarStatusPedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void atualizarStatusPedido(Pedido pedido) {
        pedidoRepository.findById(pedido.getId())
                .map(pedidoEntity -> {
                    pedidoEntity.setIdStatus(pedido.getIdStatus());
                    if (Objects.equals(pedido.getIdStatus(), "6")
                            && Objects.equals(pedidoEntity.getIdPagamento(),"0")) {
                        throw new RuntimeException("Pagamento não realizado!");
                    } else if (Objects.equals(pedido.getIdStatus(), "6")) {
                        pedidoEntity.setDataHoraFim(new Date());
                    }
                    return pedidoEntity;
                })
                .map(pedidoRepository::save)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
    }
}
