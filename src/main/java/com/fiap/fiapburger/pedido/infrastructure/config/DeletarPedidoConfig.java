package com.fiap.fiapburger.pedido.infrastructure.config;

import com.fiap.fiapburger.pedido.application.core.useCases.DeletarPedidoUseCase;
import com.fiap.fiapburger.pedido.infrastructure.adapters.DeletarPedidoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarPedidoConfig {
    @Bean
    public DeletarPedidoUseCase deletarPedidoUseCase(DeletarPedidoAdapter deletarPedidoAdapter){
        return new DeletarPedidoUseCase(deletarPedidoAdapter);
    }
}

