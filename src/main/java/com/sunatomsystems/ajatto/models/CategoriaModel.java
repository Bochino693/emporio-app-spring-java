package com.sunatomsystems.ajatto.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias_tb")
public class CategoriaModel implements Serializable {	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_categoria", unique = true)
	private String nomeCategoria;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoriaProduto", cascade = CascadeType.ALL)
	private List<ProdutoModel> produtosCategoria = new ArrayList<>();

	public CategoriaModel() {}

	public CategoriaModel(Long id, String nomeCategoria) {
		this.setId(id);
		this.setNomeCategoria(nomeCategoria);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}	
	
	public List<ProdutoModel> getProdutosCategoria() {
		return produtosCategoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nomeCategoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaModel other = (CategoriaModel) obj;
		return Objects.equals(id, other.id) && Objects.equals(nomeCategoria, other.nomeCategoria);
	}	
}
