package com.fiap.fiapburger.pedido.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name="pedido")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
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


	@OneToMany(cascade = ALL, mappedBy = "pedido", fetch = FetchType.EAGER)
	private List<ItensPedidoEntity> itensPedido = new ArrayList<>();

	@Override
	public String toString() {
		return itensPedido.toString();
	}
}
