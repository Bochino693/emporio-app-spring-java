package com.sunatomsystems.ajatto.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sunatomsystems.ajatto.models.CategoriaModel;
import com.sunatomsystems.ajatto.services.CategoriaServices;

@RestController
@RequestMapping(value = "/api/categories/v1")
public class CategoriaResources {
	
	@Autowired
	CategoriaServices service;	
	
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> findAll(){
			List<CategoriaModel> lista = service.findAll();
				return ResponseEntity.ok().body(lista);
	}	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaModel> findById(@PathVariable Long id){
		CategoriaModel obj = service.findById(id);
				return ResponseEntity.ok().body(obj);
	}	
	
	@PostMapping
	public ResponseEntity<CategoriaModel> insert(@RequestBody CategoriaModel obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getNomeCategoria()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaModel> update(@PathVariable Long id, @RequestBody CategoriaModel obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}		


	
	
	
	

}
