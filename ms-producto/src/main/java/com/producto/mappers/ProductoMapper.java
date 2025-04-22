package com.producto.mappers;

import org.springframework.stereotype.Component;

import com.commons.entities.Producto;
import com.commons.mappers.CommonsMapper;
import com.producto.dto.ProductoDTO;
import com.producto.repositories.ProductoRepository;

@Component
public class ProductoMapper extends CommonsMapper<ProductoDTO, Producto, ProductoRepository>{
	
	
	@Override
	public ProductoDTO entityToDTO(Producto entity) {
		ProductoDTO dto = new ProductoDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setDescripcion(entity.getDescripcion());
		dto.setPrecio(entity.getPrecio());
		dto.setStock(entity.getStock());
		return dto;
	}

	@Override
	public Producto dtoToEntity(ProductoDTO dto) {
		Producto producto = new Producto();
		producto.setId(dto.getId());
		producto.setNombre(dto.getNombre());
		producto.setDescripcion(dto.getDescripcion());
		producto.setPrecio(dto.getPrecio());
		producto.setStock(dto.getStock());
		return producto;
	}

	
}
