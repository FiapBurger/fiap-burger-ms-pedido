package com.fiap.fiapburger.pedido.application.core.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Pedido {

    private String id;
    private Integer senha;
    private String idStatus;
    private String cpf;
    private String detalhes;
    private BigDecimal valorTotal;
    private Date dataHoraInicio;
    private Date dataHoraFim;
    private String idPagamento;
    private String idSatisfacao;
    private List<Produto> itensPedido;

    public Pedido() {
    }

    public Pedido(String id, Integer senha, String idStatus, String cpf, String detalhes, BigDecimal valorTotal, Date dataHoraInicio, Date dataHoraFim, String idPagamento, String idSatisfacao, List<Produto> itensPedido) {
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

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
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

    public List<Produto> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<Produto> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
