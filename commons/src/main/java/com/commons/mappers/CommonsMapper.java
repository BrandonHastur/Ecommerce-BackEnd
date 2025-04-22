package com.commons.mappers;

import org.springframework.data.jpa.repository.JpaRepository;

public class CommonsMapper<D,E, R extends JpaRepository<E, Long>>  {
	
protected R repository;
	
	public D entityToDTO(E entity) {
		return null;
	}
	
	public E dtoToEntity(D dto) {
		return null;
	}

}
