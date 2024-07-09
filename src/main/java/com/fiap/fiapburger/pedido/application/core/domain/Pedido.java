package com.fiap.fiapburger.pedido.application.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private String id;
    private Integer senha;
    private String idStatus;
    private String cpf;
    private String detalhes;
    private BigDecimal valorTotal;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String idPagamento;
    private String idSatisfacao;
    private List<ItensPedido> itensPedido = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(String id, Integer senha, String idStatus, String cpf, String detalhes, BigDecimal valorTotal, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String idPagamento, String idSatisfacao, List<ItensPedido> itensPedido) {
        this.id = id;
        this.senha = senha;
        this.idStatus = idStatus;
        this.cpf = cpf;
        this.detalhes = detalhes;
        this.valorTotal = valorTotal;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.idPagamento = idPagamento;
        this.idSatisfacao = idSatisfacao;
        this.itensPedido = itensPedido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public String getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(String idStatus) {
        this.idStatus = idStatus;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(String idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getIdSatisfacao() {
        return idSatisfacao;
    }

    public void setIdSatisfacao(String idSatisfacao) {
        this.idSatisfacao = idSatisfacao;
    }

    public List<ItensPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItensPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", senha=" + senha +
                ", idStatus='" + idStatus + '\'' +
                ", cpf='" + cpf + '\'' +
                ", detalhes='" + detalhes + '\'' +
                ", valorTotal=" + valorTotal +
                ", dataHoraInicio=" + dataHoraInicio +
                ", dataHoraFim=" + dataHoraFim +
                ", idPagamento='" + idPagamento + '\'' +
                ", idSatisfacao='" + idSatisfacao + '\'' +
                ", itensPedido=" + itensPedido +
                '}';
    }
}
