package com.fiap.fiapburger.pedido.application.core.domain.repositories;

import java.util.Optional;

public interface PedidoRepository {
    Optional<Integer> findMaxSenha();
}
