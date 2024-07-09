package com.fiap.fiapburger.pedido.infrastructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.fiapburger.pedido.application.core.domain.ItensPedido;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class CriarPedidoRequest {

    @JsonProperty("cpf")
    @NotNull
    private String cpf;

    @JsonProperty("itensPedido")
    private List<ItensPedido> itensPedido;

}
