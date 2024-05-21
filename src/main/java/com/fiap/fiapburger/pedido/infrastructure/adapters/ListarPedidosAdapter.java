package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.ports.out.ListarPedidosOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.PedidoMapperEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListarPedidosAdapter implements ListarPedidosOutputPort {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapperEntity pedidoMapperEntity;

    public ListarPedidosAdapter(PedidoRepository pedidoRepository, PedidoMapperEntity pedidoMapperEntity) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapperEntity = pedidoMapperEntity;
    }

    @Override
    public List<PedidoResponse> listaPedidos() {
        return pedidoRepository.findAll().stream()
                .filter(pedidoEntity -> pedidoEntity.getIdStatus() != null) // Verificar se o idStatus não é nulo
                .sorted(Comparator.comparing(PedidoEntity::getIdStatus)
                        .reversed()
                        .thenComparing(PedidoEntity::getDataHoraInicio))
                .map(pedidoMapperEntity::toPedidoResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoResponse> listaPedidosPorStatus(String idStatus) {
        return pedidoRepository.findAll().stream()
                .filter(pedidoEntity -> idStatus.equals(pedidoEntity.getIdStatus())) // Evitar null pointer
                .map(pedidoMapperEntity::toPedidoResponse)
                .collect(Collectors.toList());
    }
}
