package com.clientes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientes.clients.PedidosClient;
import com.clientes.dto.ClienteDTO;
import com.clientes.mappers.ClienteMapper;
import com.clientes.repositories.ClienteRepository;
import com.commons.entities.Cliente;
import com.commons.entities.Pedido;
import com.commons.services.CommonsServiceImpl;

@Service
public class ClienteServiceImpl  extends CommonsServiceImpl<ClienteDTO, Cliente, ClienteMapper, ClienteRepository>
 implements ClienteService {

	@Autowired
	private PedidosClient client; 
	
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
	
	
	@Transactional
	public Cliente addPedido(Long idCliente, Long idPedido) {
	    Optional<Cliente> optCliente = repository.findById(idCliente);
	    if (optCliente.isPresent()) {
	        Optional<Pedido> optPedido = client.getPedidosById(idPedido);
	        if (optPedido.isPresent()) {
	            Cliente cliente = optCliente.get();
	            Pedido pedido = optPedido.get();

	            // Aseguramos bidirección
	            pedido.setCliente(cliente);
	            cliente.addPedido(pedido);

	            return repository.save(cliente);
	        }
	    }
	    return null;
	}

	
	@Transactional
	public Cliente removePedido(Long idCliente, Long idPedido) {
		Optional<Cliente> optCliente = repository.findById(idCliente);
		if (optCliente.isPresent()) {
			Optional<Pedido> optPedido = client.getPedidosById(idPedido);
			if (optPedido.isPresent()) {
				Cliente cliente = optCliente.get();
				cliente.removePedido(optPedido.get());
				return repository.save(cliente);
			}
		}
		return null;
	}

	
}
