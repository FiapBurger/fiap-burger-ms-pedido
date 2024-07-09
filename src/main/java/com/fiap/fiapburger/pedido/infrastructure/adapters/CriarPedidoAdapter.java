package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.ports.out.CriarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.ItensPedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.PedidoMapperEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.JpaPedidoRepository;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.ItensPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CriarPedidoAdapter implements CriarPedidoOutputPort {

    @Autowired
    private JpaPedidoRepository jpaPedidoRepository;

    @Autowired
    ItensPedidoRepository itensPedidoRepository;

    @Autowired
    private PedidoMapperEntity pedidoEntityMapper;


    @Override
    public PedidoEntity criarPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoEntityMapper.toPedidoEntity(pedido);

        List<ItensPedidoEntity> produtos = new ArrayList<>();
        pedido.getItensPedido().forEach(item -> {
            ItensPedidoEntity entity = new ItensPedidoEntity();
            entity.setPedido(pedidoEntity);
            entity.setNome(item.getNome());
            entity.setDescricao(item.getDescricao());
            entity.setPreco(item.getPreco());
            entity.setIdProduto(item.getId());
            entity.setCategoria(item.getCategoria());
            produtos.add(entity);
        });

        pedidoEntity.setItensPedido(produtos);
        PedidoEntity savedPedidoEntity = jpaPedidoRepository.save(pedidoEntity);

        return savedPedidoEntity;
    }


}

