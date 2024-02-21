package com.sunatomsystems.ajatto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunatomsystems.ajatto.models.FornecedorModel;
import com.sunatomsystems.ajatto.repositories.FornecedorRepositorio;
import com.sunatomsystems.ajatto.services.exceptions.ResourceNotFoundException;

@Service
public class FornecedorServices {
	
	@Autowired
	FornecedorRepositorio repositorio;

	public FornecedorServices(FornecedorRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	public List<FornecedorModel> findAll() {
		return repositorio.findAll();
	}

	public FornecedorModel findById(Long id) {
		Optional<FornecedorModel> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public FornecedorModel insert(FornecedorModel obj) {
		if (obj.getNomeFornecedor() != null && !obj.getEndereco().isBlank() && !obj.getCnpj().isBlank()
				&& !obj.getTelefone().isEmpty())
			return repositorio.save(obj);

		throw new IllegalArgumentException("Você inseriu algum dado invalido!!!");
	}

	public void delete(Long id) {
		repositorio.deleteById(id);
	}

	public FornecedorModel update(Long id, FornecedorModel obj) {
		FornecedorModel entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(FornecedorModel entity, FornecedorModel obj) {		
		entity.setNomeFornecedor(obj.getNomeFornecedor());
		entity.setEndereco(obj.getEndereco());
		entity.setCnpj(obj.getCnpj());
		entity.setTelefone(obj.getTelefone());
	}
}
