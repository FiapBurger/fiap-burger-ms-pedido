package com.fiap.fiapburger.pedido.infrastructure.api.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.fiapburger.pedido.application.core.domain.Produto;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("senha")
    private Long senha;

    @JsonProperty("id_status")
    private String idStatus;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("detalhes")
    private String detalhes;

    @JsonProperty("valor_total")
    private BigDecimal valorTotal;

    @JsonProperty("data_hora_inicio")
    private Date dataHoraInicio;

    @JsonProperty("data_hora_fim")
    private Date dataHoraFim;

    @JsonProperty("id_pagamento")
    private String idPagamento;

    @JsonProperty("id_satisfacao")
    private String idSatisfacao;

    @JsonProperty("itens_pedido")
    private List<Produto> itensPedido;
}
