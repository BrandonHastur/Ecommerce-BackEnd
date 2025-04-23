package com.producto.controller;

import org.springframework.web.bind.annotation.RestController;

import com.commons.controllers.CommonsController;
import com.producto.dto.ProductoDTO;
import com.producto.services.ProductoService;


@RestController
public class ProductoController extends CommonsController<ProductoDTO, ProductoService>{

	public ProductoController(ProductoService service) {
		super(service);
	}
	
}
