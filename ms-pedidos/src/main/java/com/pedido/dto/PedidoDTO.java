package com.pedido.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class PedidoDTO {

	
	private Long id;
	
	@NotNull(message = "El idCliente Necesita un cliente ")
	private Long idCliente;
	
	@Max(value = 4, message = "El estatus no puede ser mayor a 4")
	@Min(value = 1, message = "El estatus no puede ser menor a 1")
	private Long idEstatus;
	
	@NotNull(message = "el id producto no puede ser nulo")
	private List<Long> idProducto;
	
	private Double total;
	
	@PastOrPresent(message = "La fecha de creacion no puede ser posteior al dia de hoy ")
	private LocalDate fechaCreacion;
	
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

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	


	
}
