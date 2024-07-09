package com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.impl;

import com.fiap.fiapburger.pedido.application.core.domain.repositories.PedidoRepository;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.JpaPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class PedidoRepositoryImpl  implements PedidoRepository {

    @Autowired
    private JpaPedidoRepository jpaPedidoRepository;

    @Override
    public Optional<Integer> findMaxSenha() {
        return jpaPedidoRepository.findMaxSenha();
    }
}
