package com.fiap.fiapburger.pedido.infrastructure.persistence.mappers;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoEntityMapper {
    PedidoEntity toPedidoEntity(Pedido pedido);
}
