package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fiap.fiapburger.pedido.application.core.domain.Pedido;
import com.fiap.fiapburger.pedido.application.core.domain.Produto;
import com.fiap.fiapburger.pedido.application.core.exceptions.ExceptionsMessageEnum;
import com.fiap.fiapburger.pedido.application.core.exceptions.PedidoNaoEncontradoException;
import com.fiap.fiapburger.pedido.application.ports.out.BuscarPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.pedido.infrastructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.pedido.infrastructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.pedido.infrastructure.persistence.mappers.StatusMapper;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarPedidoAdapter implements BuscarPedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private final PedidoMapper pedidoMapper;

    @Autowired
    private final StatusMapper statusMapper;

    public BuscarPedidoAdapter(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper, StatusMapper statusMapper) {
        this.pedidoMapper = pedidoMapper;
        this.statusMapper = statusMapper;
        this.pedidoRepository = pedidoRepository;
    }


    @Override
    public PedidoResponse buscar(Pedido pedido) {

        PedidoResponse pedidoResponse = new PedidoResponse();

        PedidoEntity pedidoEntity = pedidoRepository.findById(pedido.getId())
                .orElseThrow(() -> new PedidoNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value()));

        pedidoResponse = pedidoMapper.toPedidoResponse(pedidoEntity);

        pedidoResponse.setIdStatus(statusMapper.atualizarStatus(pedidoEntity.getIdStatus()));

        List<Produto> itensPedido = new ArrayList<>();
        Produto produto1 = new Produto();
        produto1.setId("48de37ee-a8aa-4455-baca-bc4a87205a5a");
        produto1.setNome("Hamburguer");
        produto1.setPreco(new BigDecimal("10.0"));
        produto1.setDescricao("Pao, alface, molho, queijo");
        produto1.setUrlImagem(null);
        produto1.setIdCategoria("Lanches");
        itensPedido.add(produto1);

        Produto produto2 = new Produto();
        produto2.setId("58de37ee-1233-4455-baca-bc4a87205a23");
        produto2.setNome("Coca-cola");
        produto2.setPreco(new BigDecimal("5.0"));
        produto2.setDescricao("Sem acucar");
        produto2.setUrlImagem(null);
        produto2.setIdCategoria("Bebida");
        itensPedido.add(produto2);

        Produto produto3 = new Produto();
        produto3.setId("29de37ee-1233-4455-baca-bc4a87205a44");
        produto3.setNome("Batata frita");
        produto3.setPreco(new BigDecimal("7.0"));
        produto3.setDescricao("");
        produto3.setUrlImagem(null);
        produto3.setIdCategoria("Acompanhamento");
        itensPedido.add(produto3);

        pedidoResponse.setItensPedido(itensPedido);

        return pedidoResponse;

    }
}

