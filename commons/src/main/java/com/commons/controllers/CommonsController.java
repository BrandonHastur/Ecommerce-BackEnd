package com.commons.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.commons.services.CommonsService;

import jakarta.validation.Valid;

public class CommonsController <D, S extends CommonsService<D>>{


	@Autowired
	protected S service;

	public CommonsController(S service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<D>> getAll() {
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<D> getById(@PathVariable Long id){
		Optional<D> dto = service.obtenerPorId(id);
		if (dto.isPresent()) {
			return ResponseEntity.ok(dto.get());
		}
		return ResponseEntity.notFound().build();
		
	}
	@PostMapping
	public ResponseEntity<?> post(@Valid @RequestBody D dto , BindingResult result ){
		if (result.hasErrors()) {
			return this.validate(result);
		}
		return ResponseEntity.ok(service.insertar(dto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> put(@Valid @RequestBody D dto , BindingResult result, @PathVariable Long id){
		if(result.hasErrors())
			return this.validate(result);
		if (result.hasErrors()) {
			return this.validate(result);
		}
		return ResponseEntity.ok(service.editar(dto, id));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<D> delete(@PathVariable Long id){
		D dto = service.eliminar(id);
		if (dto != null) {
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.notFound().build();
	}
	
	protected ResponseEntity<?> validate(BindingResult result) {
		Map<String,Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(error -> {
			errores.put(error.getField(), 
					"Campo " + error.getField() + " " + error.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
	
}
