package com.commons.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUCTO")
public class Producto {
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCTO" )
	@SequenceGenerator (name = "SEQ_PRODUCTO", sequenceName = "SEQ_PRODUCTO", allocationSize = 1)
	@Column(name="ID_PRODUCTO")
	Long id;
	
	@Column(name = "NOMBRE")
	String nombre;
	
	@Column(name = "DESCRIPCION")
	String descripcion;
	
	@Column(name = "PRECIO")
	Double precio;
	
	@Column(name = "STOCK")
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	
	
	
}
