package com.fiap.fiapburger.pedido.infrastructure.config;

import com.fiap.fiapburger.pedido.application.core.useCases.AvaliarPedidoUseCase;
import com.fiap.fiapburger.pedido.infrastructure.adapters.AvaliarPedidoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvaliarPedidoConfig {
    @Bean
    public AvaliarPedidoUseCase avaliarPedidoUseCase(AvaliarPedidoAdapter avaliarPedidoAdapter) {
        return new AvaliarPedidoUseCase(avaliarPedidoAdapter);
    }
}

