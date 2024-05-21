package com.fiap.fiapburger.pedido.infrastructure.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PagamentoResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("nome")
    private String nome;

}
