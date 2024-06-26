package com.fiap.fiapburger.pedido.infrastructure.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ConsultarStatusPagamentoResponse {

    @NotBlank
    @JsonProperty("pedido")
    private String idPedido;

    @JsonProperty("meio_pagamento")
    private String tipoPagamento;

    @JsonProperty("valor")
    private BigDecimal valor;

    @JsonProperty("status")
    private String status;

    @JsonProperty("senha")
    private Integer senha;

    @JsonProperty("mensagem")
    private String mensagem;
}
