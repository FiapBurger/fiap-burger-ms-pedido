package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.ports.in.EfetuarPagamentoInputPort;
import com.fiap.fiapburger.pedido.application.ports.out.EfetuarPagamentoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.EfetuarPagamentoRequest;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.EfetuarPagamentoResponse;

public class EfetuarPagamentoUseCase implements EfetuarPagamentoInputPort {

    private final EfetuarPagamentoOutputPort efetuarPagamentoOutputPortPort;

    public EfetuarPagamentoUseCase(EfetuarPagamentoOutputPort efetuarPagamentoOutputPortPort) {
        this.efetuarPagamentoOutputPortPort = efetuarPagamentoOutputPortPort;
    }

    @Override
    public EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoRequest efetuarPagamentoRequest) {
        EfetuarPagamentoResponse efetuarPagamentoResponse = efetuarPagamentoOutputPortPort.efetuarPagamento(efetuarPagamentoRequest);
        return efetuarPagamentoResponse;
    }
}
