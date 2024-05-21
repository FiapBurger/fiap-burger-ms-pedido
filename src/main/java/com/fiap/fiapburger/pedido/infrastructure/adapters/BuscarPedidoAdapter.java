package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.core.exceptions.ExceptionsMessageEnum;
import com.fiap.fiapburger.pedido.application.core.exceptions.PedidoNaoEncontradoException;
import com.fiap.fiapburger.pedido.application.ports.out.BuscarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.StatusMapper;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarPedidoAdapter implements BuscarPedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private final PedidoMapper pedidoMapper;

    @Autowired
    private final StatusMapper statusMapper;

    public BuscarPedidoAdapter(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper, StatusMapper statusMapper) {
        this.pedidoMapper = pedidoMapper;
        this.statusMapper = statusMapper;
        this.pedidoRepository = pedidoRepository;
    }


    @Override
    public PedidoResponse buscar(Pedido pedido) {

        PedidoResponse pedidoResponse = new PedidoResponse();

        PedidoEntity pedidoEntity = pedidoRepository.findById(pedido.getId())
                .orElseThrow(() -> new PedidoNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value()));

        pedidoResponse = pedidoMapper.toPedidoResponse(pedidoEntity);

        pedidoResponse.setIdStatus(statusMapper.atualizarStatus(pedidoEntity.getIdStatus()));

        return pedidoResponse;

    }
}

