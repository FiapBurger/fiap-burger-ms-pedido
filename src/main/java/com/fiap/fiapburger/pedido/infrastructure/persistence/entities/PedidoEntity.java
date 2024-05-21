package com.fiap.fiapburger.pedido.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="pedido")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class PedidoEntity extends Date {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idPedido;

	private Integer senha;
	private String idStatus;
	private String cpf;
	private String detalhes;
	private BigDecimal valorTotal;
	private Date dataHoraInicio;
	private Date dataHoraFim;
	private String idPagamento;
	private String idSatisfacao;

	@OneToMany(mappedBy="pedido")
	private List<ProdutoEntity> itensPedido;
		
}
