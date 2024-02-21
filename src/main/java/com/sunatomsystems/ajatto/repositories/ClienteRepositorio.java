package com.sunatomsystems.ajatto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunatomsystems.ajatto.models.ClienteModel;

public interface ClienteRepositorio extends JpaRepository<ClienteModel, Long> {

}
