package com.fiap.fiapburger.pedido.infrastructure.persistence.repositories;

import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, String> {
    @Query("SELECT MAX(p.senha) FROM PedidoEntity p")
    Optional<Integer> findMaxSenha();
}
