package com.pedido.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commons.controllers.CommonsController;
import com.pedido.dto.PedidoDTO;
import com.pedido.services.PedidoService;
import com.pedido.services.PedidoServiceImpl;

@RestController
public class PedidoController extends CommonsController<PedidoDTO, PedidoService>{

	@Autowired
	private PedidoServiceImpl serviceImpl;
	
	public PedidoController(PedidoService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/activos")
	public ResponseEntity<List<PedidoDTO>> buscarPedidosAvtivos() {
		return ResponseEntity.ok(serviceImpl.listarPedidosActivos());
	}

}
