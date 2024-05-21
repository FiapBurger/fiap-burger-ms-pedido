package com.fiap.fiapburger.pedido.application.core.domain.enums;

public enum StatusPedido {
    PEDIDO_CRIADO(1),
    PAGAMENTO_EFETUADO(2),
    RECEBIDO(3),
    EM_PREPARO(4),
    PRONTO(5),
    ENTREGUE_AO_CLIENTE(6);

    private final int id;

    StatusPedido(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
