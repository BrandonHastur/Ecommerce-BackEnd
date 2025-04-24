package com.clientes.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.commons.entities.Pedido;

@FeignClient("ms-pedidos")
public interface PedidosClient {

	@GetMapping("/{id}")
	public Optional<Pedido> getPedidosById(@PathVariable Long id);
}
