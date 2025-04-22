package com.clientes.mappers;

import org.springframework.stereotype.Component;

import com.clientes.dto.ClienteDTO;
import com.clientes.repositories.ClienteRepository;
import com.commons.entities.Cliente;
import com.commons.mappers.CommonsMapper;

@Component
public class ClienteMapper extends CommonsMapper<ClienteDTO, Cliente, ClienteRepository> {

	@Override
	public ClienteDTO entityToDTO(Cliente entity) {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());
		dto.setEmail(entity.getEmail());
		dto.setTelefono(entity.getTelefono());
		dto.setDireccion(entity.getDireccion());
		return dto;
	}

	@Override
	public Cliente dtoToEntity(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		cliente.setId(dto.getId());
		cliente.setNombre(dto.getNombre());
		cliente.setApellido(dto.getApellido());
		cliente.setEmail(dto.getEmail());
		cliente.setTelefono(dto.getTelefono());
		cliente.setDireccion(dto.getDireccion());
		return cliente;
	}

	
	
}
