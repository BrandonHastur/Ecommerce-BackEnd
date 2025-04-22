package com.commons.services;

import java.util.List;
import java.util.Optional;

public interface CommonsService<D> {

	List<D> listar();
	
	Optional<D> obtenerPorId(Long id);
	
	D insertar(D dto);
	
	D editar(D dto , Long id);
	
	D eliminar(Long id);
}
