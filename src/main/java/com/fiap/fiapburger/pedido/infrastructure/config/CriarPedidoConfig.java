package com.fiap.fiapburger.pedido.infrastructure.config;

import com.fiap.fiapburger.pedido.application.core.useCases.CriarPedidoUseCase;
import com.fiap.fiapburger.pedido.application.core.useCases.GerarSenhaUseCase;
import com.fiap.fiapburger.pedido.infrastructure.adapters.CriarPedidoAdapter;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.PedidoMapperEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CriarPedidoConfig {
    @Bean
    public CriarPedidoUseCase criarPedidoUseCase(CriarPedidoAdapter criarPedidoAdapter, PedidoMapperEntity pedidoMapperEntity, GerarSenhaUseCase gerarSenhaUseCase) {
        return new CriarPedidoUseCase(criarPedidoAdapter, pedidoMapperEntity,gerarSenhaUseCase);
    }
}

