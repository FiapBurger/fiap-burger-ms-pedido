package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GerarSenhaUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    public int gerarNovaSenha() {
        Optional<Integer> maxSenha = pedidoRepository.findMaxSenha();
        return maxSenha.map(s -> s + 1).orElse(1);
    }
}
