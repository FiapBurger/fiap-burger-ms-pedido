package com.fiap.fiapburger.pedido.infrastructure.persistence.mappers;

import com.fiap.fiapburger.pedido.application.core.domain.Historico;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.HistoricoRequest;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.HistoricoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoricoMapper {
    HistoricoEntity toHistoricoEntity(Historico historicoDTO);
    Historico toHistoricoDTO (HistoricoRequest historicoRequest);
}
