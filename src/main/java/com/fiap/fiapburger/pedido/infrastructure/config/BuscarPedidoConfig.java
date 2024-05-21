package com.fiap.fiapburger.pedido.infrastructure.config;

import com.fiap.fiapburger.pedido.application.core.useCases.BuscarPedidoUseCase;
import com.fiap.fiapburger.pedido.infrastructure.adapters.BuscarPedidoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarPedidoConfig {

    @Bean
    public BuscarPedidoUseCase buscarPedidoUseCase(BuscarPedidoAdapter buscarPedidoAdapter) {
        return new BuscarPedidoUseCase(buscarPedidoAdapter);
    }

}
