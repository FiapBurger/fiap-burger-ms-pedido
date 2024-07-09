package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.ports.out.EfetuarPagamentoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.EfetuarPagamentoRequest;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.EfetuarPagamentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EfetuarPagamentoAdapter implements EfetuarPagamentoOutputPort {

    private final RestTemplate restTemplate;

    @Autowired
    public EfetuarPagamentoAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoRequest efetuarPagamentoRequest) {
        String servicoPagamentoUrl = "http://pagamento-service/efetuar-pagamento";
        return restTemplate.postForObject(servicoPagamentoUrl, efetuarPagamentoRequest, EfetuarPagamentoResponse.class);
    }
}
