package com.sunatomsystems.ajatto.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos_tb")
public class ProdutoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name = "nome_produto")
	private String nomeProduto;
	
	@Column(name = "preco_unitario")
	private Double precoUnitario;	
	
	@Column(name = "preco_fornecedor")
	private Double precoFornecedor;
	
	@Column(name = "descricao")
	private String descricao;	

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private FornecedorModel fornecedor;
	
	@ManyToOne
	@JoinColumn(name = "nome_categoria_id")
	private CategoriaModel categoriaProduto;
	
	public ProdutoModel() {}

	public ProdutoModel(Long id, String nomeProduto, Double precoUnitario,
			Double precoFornecedor, String descricao) {
		this.setId(id);
		this.setNomeProduto(nomeProduto.toUpperCase());
		this.setPrecoUnitario(precoUnitario);
		this.setPrecoFornecedor(precoFornecedor);
		this.setDescricao(descricao);
//		this.setFornecedor(fornecedor);
//		this.setCategoriaProduto(categoria);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}	

	public Double getPrecoFornecedor() {
		return precoFornecedor;
	}

	public void setPrecoFornecedor(Double precoFornecedor) {
		this.precoFornecedor = precoFornecedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public FornecedorModel getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorModel fornecedor) {
		this.fornecedor = fornecedor;
	}

	public CategoriaModel getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaModel categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
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
		ProdutoModel other = (ProdutoModel) obj;
		return Objects.equals(id, other.id);
	}	
	
}
