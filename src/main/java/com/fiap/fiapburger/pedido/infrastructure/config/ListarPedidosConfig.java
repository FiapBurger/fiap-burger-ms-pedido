package com.fiap.fiapburger.pedido.infrastructure.config;

import com.fiap.fiapburger.pedido.application.core.useCases.ListarPedidosUseCase;
import com.fiap.fiapburger.pedido.infrastructure.adapters.ListarPedidosAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarPedidosConfig {
    @Bean
    public ListarPedidosUseCase listarPedidosUseCase(ListarPedidosAdapter listarPedidosAdapter) {
        return new ListarPedidosUseCase(listarPedidosAdapter);
    }
}
