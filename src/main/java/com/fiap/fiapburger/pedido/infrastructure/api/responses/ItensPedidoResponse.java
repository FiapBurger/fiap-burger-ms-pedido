package com.fiap.fiapburger.pedido.infrastructure.api.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItensPedidoResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("id_pedido")
    private String idPedido;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("url_imagem")
    private String urlImagem;

    @JsonProperty("preco")
    private BigDecimal preco;

    @JsonProperty("categoria")
    private String categoria;
}
