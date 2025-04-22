package com.producto.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ProductoDTO {
	
	Long id;
	
	
	@NotNull(message = "El nombre no puede ser nulo")
	String nombre;
	
	@NotNull(message = "La descripcion no puede ser nula")
	String descripcion;
	
	@Min(value = 1 , message = " no puede ser negativo o igual a cero")
	@NotNull(message = "El precio no puede ser nulo")
	Long precio;
	
	@Min(value = 0 , message = "El stock no puede ser negativo")
	@NotNull(message = "El stock no puede ser nulo")
	Long stock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	
}
