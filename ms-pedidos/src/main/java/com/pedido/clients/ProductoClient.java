package com.pedido.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.commons.entities.Producto;

@FeignClient(name = "ms-producto")
public interface ProductoClient {

	@GetMapping("/{id}")
	public Producto getProductoById(@PathVariable Long id);
}
