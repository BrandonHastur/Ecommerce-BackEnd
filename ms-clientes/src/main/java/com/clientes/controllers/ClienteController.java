package com.clientes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.dto.ClienteDTO;
import com.clientes.services.ClienteService;
import com.clientes.services.ClienteServiceImpl;
import com.commons.controllers.CommonsController;
import com.commons.entities.Cliente;

@RestController
public class ClienteController extends CommonsController<ClienteDTO, ClienteService> {

	@Autowired
	private ClienteServiceImpl service;
	
	public ClienteController(ClienteService service) {
		super(service);
	}

	@PutMapping("/pedido-add/{idCliente}/{idPedido}")
	public ResponseEntity<Cliente> addCurso(@PathVariable Long idCliente, @PathVariable Long idPedido) {
	    Cliente cliente = service.addPedido(idCliente, idPedido);
	    if (cliente != null) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	    }
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PutMapping("/pedido-remove/{idCliente}/{idPedido}")
	public ResponseEntity<Cliente> removeCurso(@PathVariable Long idCliente, @PathVariable Long idPedido) {
	    Cliente cliente = service.removePedido(idCliente, idPedido);
	    if (cliente != null) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	    }
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
