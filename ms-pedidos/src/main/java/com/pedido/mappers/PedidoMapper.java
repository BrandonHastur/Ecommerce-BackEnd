package com.pedido.mappers;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.commons.entities.Cliente;
import com.commons.entities.Pedido;
import com.commons.entities.Producto;
import com.commons.mappers.CommonsMapper;
import com.pedido.clients.ClienteClient;
import com.pedido.clients.ProductoClient;
import com.pedido.dto.PedidoDTO;
import com.pedido.repositories.PedidoRepository;

@Component
public class PedidoMapper extends CommonsMapper<PedidoDTO, Pedido, PedidoRepository> {

	@Autowired
	private ProductoClient productoClient;
	
	@Autowired
	private ClienteClient clienteClient;
	
	@Override
	public PedidoDTO entityToDTO(Pedido entity) {
		PedidoDTO dto = new PedidoDTO();
		dto.setId(entity.getId());
		dto.setIdEstatus(entity.getIdEstatus());
		dto.setIdCliente(entity.getCliente().getId());
		 // Convertimos lista de productos a lista de IDs
	    List<Long> idP = entity.getProductos().stream()
	        .map(Producto::getId)
	        .collect(Collectors.toList());
	    dto.setIdProducto(idP);
	    dto.setTotal(entity.getTotal());
	    dto.setFechaCreacion(entity.getFechaCreacion());
	    return dto;
	}

	@Override
	public Pedido dtoToEntity(PedidoDTO dto) {
		Pedido pedido = new Pedido();
		pedido.setId(dto.getId());
		try {
			Cliente cliente = clienteClient.getClienteById(dto.getIdCliente());
			pedido.setCliente(cliente); 
		} catch (Exception e) {
		    throw new RuntimeException("El cliente con ID " + dto.getIdCliente() + " no existe.");
		}

		pedido.setIdEstatus(dto.getIdEstatus());
		List<Producto> lista = dto.getIdProducto().stream()
			    .map(id -> productoClient.getProductoById(id)) // o usar repository
			    .collect(Collectors.toList());
		pedido.setProductos(lista);
		if (pedido.getProductos() != null) {
			pedido.setTotal(calcularTotalPedido(pedido));

		}
		pedido.setFechaCreacion(dto.getFechaCreacion());
		return pedido;
	}

	private Double calcularTotalPedido(Pedido pedido) {
		Double total = pedido.getProductos()
                .stream()
                .mapToDouble(producto -> producto.getPrecio())
                .sum();
		return total;
	}
	
}
