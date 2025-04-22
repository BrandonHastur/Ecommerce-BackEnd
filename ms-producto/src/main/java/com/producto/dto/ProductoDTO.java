package com.producto.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ProductoDTO {
	
	Long id;
	Long idPedido;
	
	@Max(value = 32, message = "El nombre no puede tener mas de 32 caracteres")
	@NotNull(message = "El nombre no puede ser nulo")
	String nombre;
	
	@Max(value= 99, message= "La descripcion no puede tener mas de 99 caracteres")
	@NotNull(message = "La descripcion no puede ser nula")
	String descripcion;
	
	@Max(value= 10, message= "El precio no puede tener mas de 10 caracteres")
	@Min(value= 1, message= "El precio no puede tener menos de 1 caracter")
	@NotNull(message = "El precio no puede ser nulo")
	Long precio;
	
	@Max(value= 10, message= "El stock no puede tener mas de 10 caracteres")
	@Min(value= 1, message= "El stock no puede tener menos de 1 caracter")
	@NotNull(message = "El stock no puede ser nulo")
	Long stock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
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
