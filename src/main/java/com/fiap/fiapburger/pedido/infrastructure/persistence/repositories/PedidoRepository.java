package com.fiap.fiapburger.pedido.infrastructure.persistence.repositories;

import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, String> {
}
