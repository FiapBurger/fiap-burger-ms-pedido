package com.fiap.fiapburger.pedido.application.ports.in;

import com.fiap.fiapburger.pedido.infrastructure.api.requests.EfetuarPagamentoRequest;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.EfetuarPagamentoResponse;

public interface EfetuarPagamentoInputPort {
    EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoRequest efetuarPagamentoRequest);
}
