package com.fiap.fiapburger.pedido.infrastructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EfetuarPagamentoRequest {

    @JsonProperty("id_pedido")
    private String idPedido;

    @JsonProperty("id_pagamento")
    private String idPagamento;

    @JsonProperty("valor_total")
    private String valorTotal;
}
