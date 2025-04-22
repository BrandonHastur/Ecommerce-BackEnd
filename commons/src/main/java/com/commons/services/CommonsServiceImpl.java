package com.commons.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.commons.mappers.CommonsMapper;

public class CommonsServiceImpl  <D , E, 
M extends CommonsMapper<D, E, R> , R extends JpaRepository<E, Long>> 
implements CommonsService<D>{

	@Autowired
	protected R repository;
	
	@Autowired
	protected M mapper;
	
	@Override
	public List<D> listar() {
		return null;
	}

	@Override
	public Optional<D> obtenerPorId(Long id) {
		return Optional.empty();
	}

	@Override
	public D insertar(D dto) {
		return null;
	}

	@Override
	public D editar(D dto, Long id) {
		return null;
	}

	@Override
	public D eliminar(Long id) {
		return null;
	}

}
