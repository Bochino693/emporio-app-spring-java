package com.sunatomsystems.ajatto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunatomsystems.ajatto.models.ProdutoModel;
import com.sunatomsystems.ajatto.repositories.ProdutoRepositorio;
import com.sunatomsystems.ajatto.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoServices {
	
	@Autowired
	 ProdutoRepositorio repositorio;
	
	public List<ProdutoModel> findAll(){
		return repositorio.findAll();		
	}
	
	public ProdutoModel findById(Long id) {
		Optional<ProdutoModel> obj = repositorio.findById(id);
				return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}	
	
	public ProdutoModel insert(ProdutoModel obj) {
		if(obj.getNomeProduto() != null 
			&& !obj.getNomeProduto().isBlank()
			&& !obj.getNomeProduto().isEmpty()
			) 	return repositorio.save(obj);
		
		throw new IllegalArgumentException("Você inseriu algum dado invalido!!!");
	}
	
	public void delete(Long id) {
		repositorio.deleteById(id);		
	}
	
	public ProdutoModel update(Long id, ProdutoModel obj) {
		ProdutoModel entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(ProdutoModel entity, ProdutoModel obj) {
			entity.setNomeProduto(obj.getNomeProduto());
			entity.setPrecoUnitario(obj.getPrecoUnitario());
			
	}
}
