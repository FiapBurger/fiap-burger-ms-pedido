package com.fiap.fiapburger.pedido.infrastructure.config;

import com.fiap.fiapburger.pedido.application.core.useCases.AtualizarStatusPedidoUseCase;
import com.fiap.fiapburger.pedido.infrastructure.adapters.AtualizarStatusPedidoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarStatusPedidoConfig {
    @Bean
    public AtualizarStatusPedidoUseCase atualizarStatusPedido(AtualizarStatusPedidoAdapter atualizarStatusPedidoAdapter) {
        return new AtualizarStatusPedidoUseCase(atualizarStatusPedidoAdapter);
    }
}
