package com.producto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commons.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
