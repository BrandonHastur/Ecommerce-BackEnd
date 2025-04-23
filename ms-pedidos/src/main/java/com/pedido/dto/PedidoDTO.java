package com.pedido.dto;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PedidoDTO {

	
	Long id;
	
	@NotNull(message = "El idCliente Necesita un cliente ")
	Long idCliente;
		
	@Max(value = 5, message = "el estatus debe ser menor 5")
	@Min(value = 1, message = "el estatus debe ser mayor a 0")
	@NotNull(message = "el id estatus no puede ser nulo")
	Long idEstatus;
	
	@NotNull(message = "el id producto no puede ser nulo")
	List<Long> idProducto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Long idEstatus) {
		this.idEstatus = idEstatus;
	}

	public List<Long> getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(List<Long> idProducto) {
		this.idProducto = idProducto;
	}


	
}
