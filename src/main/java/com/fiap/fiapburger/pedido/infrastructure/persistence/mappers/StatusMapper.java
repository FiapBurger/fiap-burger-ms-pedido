package com.fiap.fiapburger.pedido.infrastructure.persistence.mappers;

import com.fiap.fiapburger.pedido.application.core.domain.enums.StatusPedido;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatusMapper {
    private static final Map<String, String> STATUS_MAP = new HashMap<>();

    static {
        STATUS_MAP.put("1", StatusPedido.PEDIDO_CRIADO.name());
        STATUS_MAP.put("2", StatusPedido.PAGAMENTO_EFETUADO.name());
        STATUS_MAP.put("3", StatusPedido.RECEBIDO.name());
        STATUS_MAP.put("4", StatusPedido.EM_PREPARO.name());
        STATUS_MAP.put("5", StatusPedido.PRONTO.name());
        STATUS_MAP.put("6", StatusPedido.ENTREGUE_AO_CLIENTE.name());
    }

    public String getStatus(String idStatus) {
       return STATUS_MAP.getOrDefault(idStatus, "Status Desconhecido");
    }
}
