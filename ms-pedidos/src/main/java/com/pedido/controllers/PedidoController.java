package com.pedido.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.commons.controllers.CommonsController;
import com.pedido.dto.PedidoDTO;
import com.pedido.services.PedidoService;

@RestController
public class PedidoController extends CommonsController<PedidoDTO, PedidoService>{

	public PedidoController(PedidoService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}
