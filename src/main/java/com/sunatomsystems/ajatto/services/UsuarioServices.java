package com.sunatomsystems.ajatto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunatomsystems.ajatto.models.UsuarioModel;
import com.sunatomsystems.ajatto.repositories.UsuarioRepositorio;
import com.sunatomsystems.ajatto.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioServices {	
	
	@Autowired
	UsuarioRepositorio repositorio;

	public UsuarioServices(UsuarioRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	public List<UsuarioModel> findAll() {
		return repositorio.findAll();
	}

	public UsuarioModel findById(Long id) {
		Optional<UsuarioModel> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public UsuarioModel insert(UsuarioModel obj) {
		if (obj.getNome() != null && !obj.getSenha().isBlank() && !obj.getUserName().isBlank()
				&& !obj.getSenha().isEmpty())
			return repositorio.save(obj);

		throw new IllegalArgumentException("Você inseriu algum dado invalido!!!");
	}

	public void delete(Long id) {
		repositorio.deleteById(id);
	}

	public UsuarioModel update(Long id, UsuarioModel obj) {
		UsuarioModel entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(UsuarioModel entity, UsuarioModel obj) {		
		entity.setUserName(obj.getUserName());
		entity.setNome(obj.getNome());
		entity.setSenha(obj.getSenha());

	}
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		var user = repositorio.findByUserName(username);
//		if (user != null) 
//			return user;
//		 else 
//			throw new UsernameNotFoundException("Username: " + username + " not found!");		
//	}
}
