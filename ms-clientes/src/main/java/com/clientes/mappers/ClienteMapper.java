package com.clientes.mappers;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.clientes.dto.ClienteDTO;
import com.clientes.dto.PedidoDTO;
import com.clientes.repositories.ClienteRepository;
import com.commons.entities.Cliente;
import com.commons.entities.Pedido;
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

	    // Mapeamos los pedidos también
	    if (entity.getPedidos() != null && !entity.getPedidos().isEmpty()) {
	        List<PedidoDTO> pedidosDTO = entity.getPedidos().stream()
	            .map(this::pedidoToDTO) // asegúrate de tener este método
	            .collect(Collectors.toList());
	        dto.setPedidos(pedidosDTO);
	    }

	    return dto;
	}


	@Override
	public Cliente dtoToEntity(ClienteDTO dto) {
	    if (dto.getTelefono() != null) {
	        int longitud = String.valueOf(dto.getTelefono()).length();
	        if (longitud != 10) {
	            throw new IllegalArgumentException("El teléfono debe tener exactamente 10 dígitos");
	        }
	    }
		Cliente cliente = new Cliente();
		cliente.setId(dto.getId());
		cliente.setNombre(dto.getNombre());
		cliente.setApellido(dto.getApellido());
		cliente.setEmail(dto.getEmail());
		cliente.setTelefono(dto.getTelefono());
		cliente.setDireccion(dto.getDireccion());
//		cliente.setPedidos(dto.getPedidos());
		return cliente;
	}

	
	public PedidoDTO pedidoToDTO(Pedido pedido) {
	    PedidoDTO dto = new PedidoDTO();
	    dto.setId(pedido.getId());
	    dto.setTotal(pedido.getTotal());
	    dto.setIdEstatus(pedido.getIdEstatus());
	    // Si necesitas mapear productos también, aquí lo haces
	    return dto;
	}
	
}
