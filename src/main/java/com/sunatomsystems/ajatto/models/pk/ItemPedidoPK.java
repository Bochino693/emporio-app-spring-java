package com.sunatomsystems.ajatto.models.pk;

import java.io.Serializable;
import java.util.Objects;

import com.sunatomsystems.ajatto.models.PedidoModel;
import com.sunatomsystems.ajatto.models.ProdutoModel;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ItemPedidoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private PedidoModel pedido;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private ProdutoModel produto;
	

	public PedidoModel getPedido() {
		return pedido;
	}

	public void setPedido(PedidoModel pedido) {
		this.pedido = pedido;
	}

	public ProdutoModel getProduto() {
		return produto;
	}

	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoPK other = (ItemPedidoPK) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(produto, other.produto);
	}	
}
