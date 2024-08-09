package com.fiap.fiapburger.pedido.application.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serial;
import java.io.Serializable;

public class PedidoMessageDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 5779174493636164213L;
    @JsonProperty("id")
    private String id;

    @JsonProperty("status_pedido")
    private String status_pedido;

    @JsonProperty("id_pagamento")
    private String id_pagamento;

    public String getId_pagamento() {
        return id_pagamento;
    }

    public void setIdPagamento(String id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public PedidoMessageDTO(String id, String status_pedido, String id_pagamento) {
        this.id = id;
        this.status_pedido = status_pedido;
        this.id_pagamento = id_pagamento;
    }

    public PedidoMessageDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdStatus() {
        return status_pedido;
    }

    public void setIdStatus(String status_pedido) {
        this.status_pedido = status_pedido;
    }
}

