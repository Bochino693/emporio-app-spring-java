package com.sunatomsystems.ajatto.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sunatomsystems.ajatto.enums.StatusPedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos_tb")
public class PedidoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name = "data_hora")
	@JsonProperty("data_hora")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime dataHoraPedido;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name =  "id_cliente")
	private ClienteModel cliente;
	
	@ManyToOne
	@JoinColumn(name =  "id_atendente")
	private UsuarioModel atendente;	
	
	@Column(name = "status_pedido")
	@JsonProperty("status_pedido")
	private Integer statusPedido;

	@OneToMany(mappedBy = "id.pedido")
	private Set <ItemPedidoModel> itens = new HashSet<>();	
	

	public PedidoModel() {}

	public PedidoModel(Long id, LocalDateTime dataHoraPedido,
			ClienteModel cliente, UsuarioModel atendente, StatusPedido statusPedido) {
		this.setId(id);
		this.setDataHoraPedido(dataHoraPedido);
		this.setCliente(cliente);
		this.setAtendente(atendente);			
		this.setStatusPedido(statusPedido);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataHoraPedido() {
		return dataHoraPedido;
	}

	public void setDataHoraPedido(LocalDateTime dataHoraPedido) {
		this.dataHoraPedido = dataHoraPedido;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public UsuarioModel getAtendente() {
		return atendente;
	}

	public void setAtendente(UsuarioModel atendente) {
		this.atendente = atendente;
	}
	
	public StatusPedido getStatusPedido() {
		return StatusPedido.valorOf(statusPedido);
	}
	
	public void setStatusPedido(StatusPedido statusPedido) {
		if(statusPedido != null)
		this.statusPedido = statusPedido.getCode();
	}	

	public Set<ItemPedidoModel> getItens() {
		return itens;
	}


	@Override
	public int hashCode() {
		return Objects.hash(atendente, cliente, dataHoraPedido, id, itens);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoModel other = (PedidoModel) obj;
		return Objects.equals(atendente, other.atendente) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(dataHoraPedido, other.dataHoraPedido) && Objects.equals(id, other.id)
				&& Objects.equals(itens, other.itens);
	}	
	
}