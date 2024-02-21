package com.sunatomsystems.ajatto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunatomsystems.ajatto.models.PedidoModel;
import com.sunatomsystems.ajatto.repositories.PedidoRepositorio;
import com.sunatomsystems.ajatto.services.exceptions.ResourceNotFoundException;

@Service
public class PedidoServices {
	
	@Autowired
	PedidoRepositorio repositorio;

	public PedidoServices(PedidoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	public List<PedidoModel> findAll() {
		return repositorio.findAll();
	}

	public PedidoModel findById(Long id) {
		Optional<PedidoModel> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public PedidoModel insert(PedidoModel obj) {
		if (obj.getCliente() != null && obj.getAtendente() != null && obj.getDataHoraPedido() != null)
			return repositorio.save(obj);

		throw new IllegalArgumentException("Você inseriu algum dado invalido!!!");
	}

	public void delete(Long id) {
		repositorio.deleteById(id);
	}

	public PedidoModel update(Long id, PedidoModel obj) {
		PedidoModel entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(PedidoModel entity, PedidoModel obj) {		
		entity.setCliente(obj.getCliente());
		entity.setAtendente(obj.getAtendente());
		entity.setDataHoraPedido(obj.getDataHoraPedido());
	}

}
