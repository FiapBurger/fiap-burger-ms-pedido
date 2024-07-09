package com.fiap.fiapburger.pedido.application.ports.out;

import com.fiap.fiapburger.pedido.infrastructure.api.requests.EfetuarPagamentoRequest;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.EfetuarPagamentoResponse;

public interface EfetuarPagamentoOutputPort {
    EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoRequest efetuarPagamentoRequest);
}
