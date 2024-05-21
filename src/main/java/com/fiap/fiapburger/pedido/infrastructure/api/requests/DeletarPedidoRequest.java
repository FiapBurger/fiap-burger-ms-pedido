package com.fiap.fiapburger.pedido.infrastructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeletarPedidoRequest {

    @JsonProperty("id_pedido")
    private String idPedido;

}
