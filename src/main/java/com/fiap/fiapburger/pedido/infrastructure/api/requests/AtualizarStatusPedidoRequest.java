package com.fiap.fiapburger.pedido.infrastructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AtualizarStatusPedidoRequest {

    @NotBlank
    @JsonProperty("id_pedido")
    private String idPedido;

    @NotBlank
    @JsonProperty("id_status")
    private String idStatus;
}
