package com.producto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.commons.entities.Producto;
import com.commons.services.CommonsServiceImpl;
import com.producto.dto.ProductoDTO;
import com.producto.mappers.ProductoMapper;
import com.producto.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl extends CommonsServiceImpl<ProductoDTO, Producto, ProductoMapper,ProductoRepository>
implements ProductoService{

	@Override
	public List<ProductoDTO> listar() {
		List<ProductoDTO> lista = new ArrayList<>();
		repository.findAll().forEach(linea -> {
			lista.add(mapper.entityToDTO(linea));
		});
		return lista;
	}

	@Override
	public Optional<ProductoDTO> obtenerPorId(Long id) {
		Optional<Producto> opt = repository.findById(id);
		if (opt.isPresent()) {
			return Optional.of(mapper.entityToDTO(opt.get()));
		}
		return  Optional.empty();
	}

	@Override
	public ProductoDTO insertar(ProductoDTO dto) {
		Producto producto = repository.save(mapper.dtoToEntity(dto));
		return mapper.entityToDTO(producto);
	}

	@Override
	public ProductoDTO editar(ProductoDTO dto, Long id) {
		Optional<Producto> opt = repository.findById(id);
		if (opt.isPresent()) {
			Producto producto = opt.get();
			producto.setNombre(dto.getNombre());
			producto.setDescripcion(dto.getDescripcion());
			producto.setPrecio(dto.getPrecio());
			producto.setStock(dto.getStock());
			repository.save(producto);
			return mapper.entityToDTO(producto);
		}	
		return null ;
		
	}

	@Override
	public ProductoDTO eliminar(Long id) {
		Optional<Producto> opt = repository.findById(id);
		if (opt.isPresent()) {
			ProductoDTO dto = mapper.entityToDTO(opt.get());
		 repository.deleteById(id);
		 return dto;
		}
		return null;
	}
}
