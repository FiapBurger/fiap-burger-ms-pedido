package com.fiap.fiapburger.pedido.infrastructure.persistence.repositories;

import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.ItensPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidoRepository extends JpaRepository<ItensPedidoEntity, String> {
}
