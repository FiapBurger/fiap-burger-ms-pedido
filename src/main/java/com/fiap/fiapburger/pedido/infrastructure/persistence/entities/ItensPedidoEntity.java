package com.fiap.fiapburger.pedido.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="produto")
public class ItensPedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private String idProduto;

	@ManyToOne(cascade = ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido")
	private PedidoEntity pedido;
	private String nome;
	private String descricao;
	private String urlImagem;
	private BigDecimal preco;
	private String categoria;

	@Override
	public String toString() {
		return "ProdutoEntity{" +
				"id=" + id +
				", idProduto='" + idProduto + '\'' +
				", pedido=" + pedido.getId() +
				", nome='" + nome + '\'' +
				", descricao='" + descricao + '\'' +
				", urlImagem='" + urlImagem + '\'' +
				", preco=" + preco +
				", categoria='" + categoria + '\'' +
				'}';
	}
}