package com.fiap.fiapburger.pedido.application.core.useCases;

import com.fiap.fiapburger.pedido.application.core.domain.ItensPedido;
import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.ports.in.CriarPedidoInputPort;
import com.fiap.fiapburger.pedido.application.ports.out.CriarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.pedido.infrastructure.api.requests.CriarPedidoRequest;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.PedidoMapperEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CriarPedidoUseCase implements CriarPedidoInputPort {

    private final CriarPedidoOutputPort criarPedidoOutputPort;

    private final PedidoMapperEntity pedidoMapperEntity;

    @Autowired
    private GerarSenhaUseCase gerarSenhaUseCase;

    public CriarPedidoUseCase(CriarPedidoOutputPort criarPedidoOutputPort, PedidoMapperEntity pedidoMapperEntity, GerarSenhaUseCase gerarSenhaUseCase) {
        this.criarPedidoOutputPort = criarPedidoOutputPort;
        this.pedidoMapperEntity = pedidoMapperEntity;
        this.gerarSenhaUseCase = gerarSenhaUseCase;
    }

    @Override
    public PedidoResponse criarPedido(CriarPedidoRequest criarPedidoRequest) {
        LocalDateTime dataHoraPedido = LocalDateTime.now();

        Pedido pedido = PedidoMapper.criarPedido(criarPedidoRequest);
        pedido.setValorTotal(calcularValorTotal(criarPedidoRequest.getItensPedido()));
        pedido.setDataHoraInicio(dataHoraPedido);
        int novaSenha = gerarSenhaUseCase.gerarNovaSenha();
        pedido.setSenha(novaSenha);
        PedidoEntity pedidoCriado = criarPedidoOutputPort.criarPedido(pedido);

        return pedidoMapperEntity.toPedidoResponse(pedidoCriado);
    }

    private BigDecimal calcularValorTotal(List<ItensPedido> itensPedidos) {
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (ItensPedido itensPedido : itensPedidos) {
            valorTotal = valorTotal.add(itensPedido.getPreco());
        }
        return valorTotal;
    }

}
