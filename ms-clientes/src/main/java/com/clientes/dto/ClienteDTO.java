package com.clientes.dto;

import java.util.List;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class ClienteDTO {

	private Long id;
	
	@NotNull(message = "El nombre no puede ser nulo")
	private String nombre;
	
	@NotNull(message = "El apellido no puede ser nulo")
	private String apellido;
	
	@Email(message = "No es un email valido")
	@NotNull(message = "El e-mail no puede ser nulo")
	private String email;
	
    @Digits(integer = 10, fraction = 0, message = "El teléfono debe tener exactamente 10 dígitos")
	@NotNull(message = "El telefono no puede ser nulo")
    private Long telefono;
	
    private String direccion;
	
	private List<PedidoDTO> pedidos;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
}
