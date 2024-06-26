package com.fiap.fiapburger.pedido.infrastructure.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class EfetuarPagamentoResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    @JsonProperty("pedido")
    private String idPedido;

    @JsonProperty("meio_pagamento")
    private String tipoPagamento;

    @JsonProperty("valor")
    private BigDecimal valor;

    @JsonProperty("status")
    private String status;

    @JsonProperty("qr_code")
    private String qrCode;

    @JsonProperty("url_webhook")
    private String urlWebhook;
}
