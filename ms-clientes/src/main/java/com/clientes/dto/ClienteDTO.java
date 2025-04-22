package com.clientes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ClienteDTO {

	Long id;
	
	@Max(value = 35, message = "El nombre debe tener un maximo de 35 caracteres")
	@NotNull(message = "El nombre no puede ser nulo")
	String nombre;
	
	@NotNull(message = "El apellido no puede ser nulo")
	@Max(value = 35, message = "El apellido debe tener un maximo de 35 caracteres")
	String apellido;
	
	@Email(message = "No es un email valido")
	@Max(value = 100, message = "El e-mail debe tener un maximo de 100 caracteres")
	@NotNull(message = "El e-mail no puede ser nulo")
	String email;
	
	@Min(value = 10, message = "El numero no puede ser menor a 10 digitos")
	@Max(value = 10, message = "El numero no puede ser mayor a 10 digitos")
	@NotNull(message = "El telefono no puede ser nulo")
	Long telefono;
	
	@Max(value = 100, message = "La direccion maxima es de 100 caracteres")
	String direccion;

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
	
	
}
