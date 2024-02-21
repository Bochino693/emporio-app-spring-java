package com.sunatomsystems.ajatto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunatomsystems.ajatto.models.ClienteModel;
import com.sunatomsystems.ajatto.services.ClienteServices;

@RestController
@RequestMapping(value = "/api/clients/v1")
public class ClienteResources {
	
	@Autowired
	private ClienteServices service;
	
	@GetMapping
	public ResponseEntity<List<ClienteModel>> findAll(){
				
		List<ClienteModel> lista = service.findAll();
			return ResponseEntity.ok().body(lista);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteModel> findById(@PathVariable Long id){
		ClienteModel obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteModel> update(@PathVariable Long id, @RequestBody ClienteModel obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}		

}
