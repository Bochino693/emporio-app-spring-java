package com.sunatomsystems.ajatto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunatomsystems.ajatto.models.UsuarioModel;

public interface UsuarioRepositorio extends JpaRepository<UsuarioModel, Long> {

}
