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

import com.sunatomsystems.ajatto.models.UsuarioModel;
import com.sunatomsystems.ajatto.services.UsuarioServices;

@RestController
@RequestMapping(value = "/api/users/v1")
public class UsuarioResources {
	
	@Autowired
	UsuarioServices service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> findAll(){
			List<UsuarioModel> lista = service.findAll();
				return ResponseEntity.ok().body(lista);
	}	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioModel> findById(@PathVariable Long id){
		UsuarioModel obj = service.findById(id);
				return ResponseEntity.ok().body(obj);
	}	
	
	@PostMapping
	public ResponseEntity<UsuarioModel> insert(@RequestBody UsuarioModel obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioModel> update(@PathVariable Long id, @RequestBody UsuarioModel obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}	
}