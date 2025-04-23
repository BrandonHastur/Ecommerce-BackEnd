package com.pedido.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public class PedidoDTO {

	
	private Long id;
	
	@NotNull(message = "El idCliente Necesita un cliente ")
	private Long idCliente;
		
	private Long idEstatus;
	
	@NotNull(message = "el id producto no puede ser nulo")
	private List<Long> idProducto;
	
	private Double total;
	

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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}


	
}
