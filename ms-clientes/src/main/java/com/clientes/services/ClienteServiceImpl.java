package com.clientes.services;

import java.lang.management.ManagementPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clientes.dto.ClienteDTO;
import com.clientes.mappers.ClienteMapper;
import com.clientes.repositories.ClienteRepository;
import com.commons.entities.Cliente;
import com.commons.services.CommonsServiceImpl;

@Service
public class ClienteServiceImpl  extends CommonsServiceImpl<ClienteDTO, Cliente, ClienteMapper, ClienteRepository>
 implements ClienteService {

	@Override
	public List<ClienteDTO> listar() {
		List<ClienteDTO> lista = new ArrayList<>();
		repository.findAll().forEach(linea -> {
			lista.add(mapper.entityToDTO(linea));
		});
		return lista;
	}

	@Override
	public Optional<ClienteDTO> obtenerPorId(Long id) {
		Optional<Cliente> opt = repository.findById(id);
		if (opt.isPresent()) {
			return Optional.of(mapper.entityToDTO(opt.get()));
		}
		return  Optional.empty();
	}

	@Override
	public ClienteDTO insertar(ClienteDTO dto) {
		Cliente cliente = repository.save(mapper.dtoToEntity(dto));
		return mapper.entityToDTO(cliente);
	}

	@Override
	public ClienteDTO editar(ClienteDTO dto, Long id) {
		Optional<Cliente> opt = repository.findById(id);
		if (opt.isPresent()) {
			Cliente cliente = opt.get();
			cliente.setNombre(dto.getNombre());
			cliente.setApellido(dto.getApellido());
			cliente.setEmail(dto.getEmail());
			cliente.setTelefono(dto.getTelefono());
			cliente.setDireccion(dto.getDireccion());
			repository.save(cliente);
			return mapper.entityToDTO(cliente);
		}	
		return null ;
		
	}

	@Override
	public ClienteDTO eliminar(Long id) {
		Optional<Cliente> opt = repository.findById(id);
		if (opt.isPresent()) {
		 ClienteDTO dto = mapper.entityToDTO(opt.get());
		 repository.deleteById(id);
		 return dto;
		}
		return null;
	}
	
}
