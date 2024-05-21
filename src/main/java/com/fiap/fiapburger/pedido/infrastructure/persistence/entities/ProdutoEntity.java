package com.fiap.fiapburger.pedido.infrastructure.persistence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String idProduto;

	@ManyToOne
	@JoinColumn(name="idPedido", nullable=false)
	private PedidoEntity pedido;
	private String nome;
	private String descricao;
	private String urlImagem;
	private BigDecimal preco;
	private String idCategoria;

}