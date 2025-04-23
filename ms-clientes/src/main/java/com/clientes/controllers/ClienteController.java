package com.clientes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.clientes.dto.ClienteDTO;
import com.clientes.services.ClienteService;
import com.commons.controllers.CommonsController;

@RestController
public class ClienteController extends CommonsController<ClienteDTO, ClienteService> {

	public ClienteController(ClienteService service) {
		super(service);
	}

}
