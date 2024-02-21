package com.sunatomsystems.ajatto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunatomsystems.ajatto.models.ClienteModel;
import com.sunatomsystems.ajatto.repositories.ClienteRepositorio;
import com.sunatomsystems.ajatto.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteServices {
	
	@Autowired
	ClienteRepositorio repositorio;
	
	 public ClienteServices() {}	
	
	
	public ClienteServices(ClienteRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	public List<ClienteModel> findAll() {
		return repositorio.findAll();
	}

	public ClienteModel findById(Long id) {
		Optional<ClienteModel> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public ClienteModel insert(ClienteModel obj) {
		if (obj.getNome() != null && !obj.getEndereco().isBlank() && !obj.getEndereco().isEmpty()
				&& !obj.getNome().isBlank())
			return repositorio.save(obj);

		throw new IllegalArgumentException("Você inseriu algum dado invalido!!!");
	}

	public void delete(Long id) {
		repositorio.deleteById(id);
	}

	public ClienteModel update(Long id, ClienteModel obj) {
		ClienteModel entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(ClienteModel entity, ClienteModel obj) {		
		entity.setNome(obj.getNome());
		entity.setCnpj(obj.getCnpj());
		entity.setEndereco(obj.getEndereco());		
	}

}
