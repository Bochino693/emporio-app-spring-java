package com.sunatomsystems.ajatto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunatomsystems.ajatto.models.ItemPedidoModel;

public interface ItensPedidoRepositorio extends JpaRepository<ItemPedidoModel, Long> {

}
