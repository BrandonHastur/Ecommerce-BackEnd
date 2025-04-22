package com.producto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producto.services.ProductoService;

@RequestMapping("/api/v1/productos")
@RestController
public class ProductoController extends CommonsController<ProductoDTO, ProductoService>{

	public ProductoController(ProductoService service) {
		super(service);
	}
	
}
