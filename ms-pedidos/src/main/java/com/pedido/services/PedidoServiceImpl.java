package com.pedido.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commons.entities.Pedido;
import com.commons.services.CommonsServiceImpl;
import com.pedido.dto.PedidoDTO;
import com.pedido.mappers.PedidoMapper;
import com.pedido.repositories.PedidoRepository;

@Service
public class PedidoServiceImpl extends CommonsServiceImpl<PedidoDTO, Pedido, PedidoMapper, 
 PedidoRepository> implements  PedidoService{

	
	
	@Override
	@Transactional (readOnly = true)
	public List<PedidoDTO> listar() {
		List<PedidoDTO> lista = new ArrayList<>();
		repository.findAll().forEach(linea -> {
			lista.add(mapper.entityToDTO(linea));
		});
		return lista;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PedidoDTO> obtenerPorId(Long id) {
		Optional<Pedido> opt = repository.findById(id);
		if (opt.isPresent()) {
			return Optional.of(mapper.entityToDTO(opt.get()));
		}
		return  Optional.empty();
	}

	@Override
	@Transactional
	public PedidoDTO insertar(PedidoDTO dto) {
		dto.setIdEstatus(1L);
		Pedido pedido = repository.save(mapper.dtoToEntity(dto));
		pedido.setFechaCreacion(LocalDate.now());
		return mapper.entityToDTO(pedido);
	}

	@Override
	@Transactional
	public PedidoDTO editar(PedidoDTO dto, Long id) {
		Optional<Pedido> opt = repository.findById(id);
		if (opt.isPresent()) {
			Pedido pedido = mapper.dtoToEntity(dto);
			pedido.setId(id);
			repository.save(pedido);
			return mapper.entityToDTO(pedido);
		
		}
	return null ;

	}


	@Override
	@Transactional
	public PedidoDTO eliminar(Long id) {
		Optional<Pedido> opt = repository.findById(id);
		if (opt.isPresent()) {
			Pedido pedido = opt.get();
			pedido.setIdEstatus(4L);
			repository.save(pedido);
			return mapper.entityToDTO(pedido);
		}	
		return null;
	}
	
	@Transactional
	public List<PedidoDTO> listarPedidosActivos() {
		List<PedidoDTO> lista = new ArrayList<>();
		repository.buscarPedidosActivos().forEach(linea -> {
			lista.add(mapper.entityToDTO(linea));
		});
		return lista;
	}
}
