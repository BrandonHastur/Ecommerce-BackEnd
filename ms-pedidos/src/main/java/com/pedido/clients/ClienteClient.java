package com.pedido.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.commons.entities.Cliente;

@FeignClient ("ms-clientes")
public interface ClienteClient {

	@GetMapping("/{id}")
	public Cliente getClienteById(@PathVariable Long id);
}
