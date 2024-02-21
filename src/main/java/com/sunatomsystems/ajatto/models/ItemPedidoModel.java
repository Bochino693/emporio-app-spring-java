package com.sunatomsystems.ajatto.models;

import java.io.Serializable;
import java.util.Objects;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sunatomsystems.ajatto.models.pk.ItemPedidoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_pedido_tb")
public class ItemPedidoModel implements Serializable {	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();	
	
	@JsonProperty("produto")
	private String nomeProduto;
	private Integer quantidade;
	private Double preco;	
	private Double subTotal;

	//private Double desconto;
	
	public ItemPedidoModel() {}

	public ItemPedidoModel(PedidoModel pedido, ProdutoModel produto, Integer quantidade, Double preco) {
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.setQuantidade(quantidade);
		this.setPreco(preco);
		this.setNomeProduto(id.getProduto().getNomeProduto());
		this.setSubTotal(subTotal(quantidade, preco));		
	}

	@JsonIgnore
	public PedidoModel getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(PedidoModel pedido) {
		this.id.setPedido(pedido);
	}
	
	@JsonIgnore
	public ProdutoModel getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(ProdutoModel produto) {
		this.id.setProduto(produto);
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public Double subTotal(Integer quantd, Double preco) {
		return quantd * preco;
	}

	public Double getSubTotal() {
		return subTotal;
	}
	
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoModel other = (ItemPedidoModel) obj;
		return Objects.equals(id, other.id);
	}	
}
