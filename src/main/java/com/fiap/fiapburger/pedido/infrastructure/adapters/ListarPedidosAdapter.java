package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.ports.out.ListarPedidosOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.JpaPedidoRepository;
import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListarPedidosAdapter implements ListarPedidosOutputPort {

    private final JpaPedidoRepository jpaPedidoRepository;

    public ListarPedidosAdapter(JpaPedidoRepository jpaPedidoRepository) {
        this.jpaPedidoRepository = jpaPedidoRepository;
    }

    @Override
    public List<PedidoResponse> listaPedidos() {
        return jpaPedidoRepository.findAll().stream()
                .filter(pedidoEntity -> pedidoEntity.getIdStatus() != null)
                .sorted(Comparator.comparing(PedidoEntity::getIdStatus)
                        .reversed()
                        .thenComparing(PedidoEntity::getDataHoraInicio))
                .map(PedidoMapper::toPedidoResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoResponse> listaPedidosPorStatus(String idStatus) {
        return jpaPedidoRepository.findAll().stream()
                .filter(pedidoEntity -> idStatus.equals(pedidoEntity.getIdStatus()))
                .map(PedidoMapper::toPedidoResponse)
                .collect(Collectors.toList());
    }
}
