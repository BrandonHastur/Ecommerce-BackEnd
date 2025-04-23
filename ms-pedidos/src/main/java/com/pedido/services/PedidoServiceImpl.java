package com.pedido.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.commons.entities.Pedido;
import com.commons.services.CommonsServiceImpl;
import com.pedido.dto.PedidoDTO;
import com.pedido.mappers.PedidoMapper;
import com.pedido.repositories.PedidoRepository;

@Service
public class PedidoServiceImpl extends CommonsServiceImpl<PedidoDTO, Pedido, PedidoMapper, 
 PedidoRepository> implements  PedidoService{

	
	
	@Override
	public List<PedidoDTO> listar() {
		List<PedidoDTO> lista = new ArrayList<>();
		repository.findAll().forEach(linea -> {
			lista.add(mapper.entityToDTO(linea));
		});
		return lista;
	}

	@Override
	public Optional<PedidoDTO> obtenerPorId(Long id) {
		Optional<Pedido> opt = repository.findById(id);
		if (opt.isPresent()) {
			return Optional.of(mapper.entityToDTO(opt.get()));
		}
		return  Optional.empty();
	}

	@Override
	public PedidoDTO insertar(PedidoDTO dto) {
		dto.setIdEstatus(1L);
		Pedido pedido = repository.save(mapper.dtoToEntity(dto));
		return mapper.entityToDTO(pedido);
	}

	@Override
	public PedidoDTO editar(PedidoDTO dto, Long id) {
		Optional<Pedido> opt = repository.findById(id);
		if (opt.isPresent()) {
			Pedido pedido = new Pedido();
			pedido.setId(dto.getId());
//			pedido.setIdCliente(dto.getIdCliente());
			pedido.setIdEstatus(dto.getIdEstatus());
			//pedido.setIdProducto(dto.getIdProducto());
			pedido.setTotal(calcularTotalPedido(pedido));  
			repository.save(pedido);
			
			return mapper.entityToDTO(pedido);
		
		}
	return null ;

	}

	private Double calcularTotalPedido(Pedido pedido) {
		Double total = 0.0;
//		pedido.getIdProducto().forEach(producto -> {
//			
//			//total += producto. 
//		});
		return total;
	}

	@Override
	public PedidoDTO eliminar(Long id) {
		Optional<Pedido> opt = repository.findById(id);
		if (opt.isPresent()) {
			Pedido pedido = opt.get();
			pedido.setIdEstatus(4L);
			return mapper.entityToDTO(opt.get());
		}	
		return null;
	}
	
	

}
