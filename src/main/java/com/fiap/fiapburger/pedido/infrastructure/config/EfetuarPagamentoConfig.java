package com.fiap.fiapburger.pedido.infrastructure.config;

import com.fiap.fiapburger.pedido.application.core.useCases.EfetuarPagamentoUseCase;
import com.fiap.fiapburger.pedido.infrastructure.adapters.EfetuarPagamentoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EfetuarPagamentoConfig {
    @Bean
    public EfetuarPagamentoUseCase efetuarPagamentoUseCase(EfetuarPagamentoAdapter efetuarPagamentoAdapter) {
        return new EfetuarPagamentoUseCase(efetuarPagamentoAdapter);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
