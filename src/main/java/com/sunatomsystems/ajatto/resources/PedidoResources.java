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

import com.sunatomsystems.ajatto.models.PedidoModel;
import com.sunatomsystems.ajatto.services.PedidoServices;

@RestController
@RequestMapping(value = "/api/orders/v1")
public class PedidoResources {
	
	@Autowired
	PedidoServices service;
	
	
	@GetMapping
	public ResponseEntity<List<PedidoModel>> findAll(){
			List<PedidoModel> lista = service.findAll();
				return ResponseEntity.ok().body(lista);
	}	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PedidoModel> findById(@PathVariable Long id){
		PedidoModel obj = service.findById(id);
				return ResponseEntity.ok().body(obj);
	}	
	
	@PostMapping
	public ResponseEntity<PedidoModel> insert(@RequestBody PedidoModel obj){
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
	public ResponseEntity<PedidoModel> update(@PathVariable Long id, @RequestBody PedidoModel obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}		
	
}