package com.sunatomsystems.ajatto.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes_tb")
public class ClienteModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_cliente", unique = true)
	private String nome;
	
	@Column(name = "cnpj", unique = true)
	private String cnpj;
	
	@Column(name = "endereco", unique = true)
	private String endereco;
	
	@Column(name = "email")
	private String email;
	
	
	@JsonIgnore
	@OneToMany
	private List<PedidoModel> listaPedidos = new ArrayList<>();	

	public ClienteModel() {}

	public ClienteModel(Long id, String nome, String cnpj, String endereco) {		
		this.setId(id);
		this.setNome(nome);
		this.setCnpj(cnpj);
		this.setEndereco(endereco);		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<PedidoModel> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<PedidoModel> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, endereco, id, listaPedidos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteModel other = (ClienteModel) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(id, other.id) && Objects.equals(listaPedidos, other.listaPedidos)
				&& Objects.equals(nome, other.nome);
	}
}