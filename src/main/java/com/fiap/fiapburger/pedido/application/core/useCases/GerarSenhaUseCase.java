package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.core.domain.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GerarSenhaUseCase {

    private final PedidoRepository pedidoRepositoryInterface;

    @Autowired
    public GerarSenhaUseCase(PedidoRepository pedidoRepository) {
        this.pedidoRepositoryInterface = pedidoRepository;
    }

    public int gerarNovaSenha() {
        Optional<Integer> maxSenha = pedidoRepositoryInterface.findMaxSenha();
        return maxSenha.map(s -> s + 1).orElse(1);
    }
}
