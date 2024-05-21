package com.fiap.fiapburger.pedido.infrastructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;

@Data
public class AvaliarPedidoRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id_pedido")
    private String idPedido;

    @JsonProperty("id_satisfacao")
    private String idSatisfacao;

}
