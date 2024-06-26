package com.fiap.fiapburger.pedido.infrastructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class HistoricoRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 3202887515941368147L;

    @JsonProperty("id")
    private String id;

    @NotBlank(message = "Id pedido não pode ser vazio!")
    @JsonProperty("id_pedido")
    private String idPedido;

    @NotBlank(message = "Status não pode ser vazio!")
    @JsonProperty("id_status")
    private String status;

    @NotBlank(message = "Data hora não podem ser vazios!")
    @JsonProperty("data_hora")
    private LocalDateTime dataHora;
}

