package com.fiap.fiapburger.pedido.infrastructure.adapters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.fiapburger.pedido.application.core.domain.PedidoMessageDTO;
import com.fiap.fiapburger.pedido.application.core.domain.enums.StatusPedido;
import com.fiap.fiapburger.pedido.application.ports.out.AtualizarStatusPedidoOutputPort;
import com.fiap.fiapburger.pedido.infrastructure.config.RabbitMqConfig;
import com.fiap.fiapburger.pedido.infrastructure.persistence.repositories.JpaPedidoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class AtualizarStatusPedidoAdapter implements AtualizarStatusPedidoOutputPort {

    @Autowired
    private JpaPedidoRepository jpaPedidoRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void atualizarStatusPedido(String pedidoJson) {
        System.out.println(pedidoJson);
        PedidoMessageDTO pedido;
        try {
            pedido = objectMapper.readValue(pedidoJson, PedidoMessageDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao desserializar mensagem", e);
        }
        jpaPedidoRepository.findById(pedido.getId())
                .map(pedidoEntity -> {
                    if (Objects.equals(pedido.getIdStatus(), String.valueOf(StatusPedido.ENTREGUE_AO_CLIENTE.getId()))
                            && Objects.equals(pedidoEntity.getIdPagamento(),"0")) {
                        throw new RuntimeException("Pagamento não realizado!");
                    } else if (Objects.equals(pedido.getIdStatus(),  String.valueOf(StatusPedido.ENTREGUE_AO_CLIENTE.getId()))) {
                        pedidoEntity.setDataHoraFim(LocalDateTime.now());
                    }
                    pedidoEntity.setIdStatus(pedido.getIdStatus());
                    pedidoEntity.setIdPagamento(pedido.getId_pagamento());
                    return pedidoEntity;
                })
                .map(jpaPedidoRepository::save)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
    }
}
