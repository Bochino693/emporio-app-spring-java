package com.sunatomsystems.ajatto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunatomsystems.ajatto.models.CategoriaModel;
import com.sunatomsystems.ajatto.repositories.CategoriaRepositorio;
import com.sunatomsystems.ajatto.services.exceptions.ResourceNotFoundException;

@Service
public class CategoriaServices {
	
	@Autowired
	CategoriaRepositorio repositorio;

	public CategoriaServices(CategoriaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	public List<CategoriaModel> findAll() {
		return repositorio.findAll();
	}

	public CategoriaModel findById(Long id) {
		Optional<CategoriaModel> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public CategoriaModel insert(CategoriaModel obj) {
		if (obj.getNomeCategoria() != null && !obj.getNomeCategoria().isBlank()
				&&	!obj.getNomeCategoria().isBlank()
				&&  !obj.getNomeCategoria().isEmpty())
			return repositorio.save(obj);

		throw new IllegalArgumentException("Você inseriu algum dado invalido!!!");
	}

	public void delete(Long id) {
		repositorio.deleteById(id);
	}

	public CategoriaModel update(Long id, CategoriaModel obj) {
		CategoriaModel entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(CategoriaModel entity, CategoriaModel obj) {		
		entity.setNomeCategoria(obj.getNomeCategoria());
	}
}
