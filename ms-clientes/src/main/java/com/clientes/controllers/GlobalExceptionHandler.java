package com.clientes.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> dataIntegrityViolationException(DataIntegrityViolationException e){
		Throwable cause = e.getRootCause();
		if(cause!= null && cause.getMessage() != null)
			return ResponseEntity.badRequest().body("Error de integirdad: " + cause.getMessage());
		
		return ResponseEntity.badRequest().body("Error en la integridad de datos");		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> constraintViolationException(ConstraintViolationException e){
			return ResponseEntity.badRequest().body("Violacion de resticcion: " + e.getMessage());
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> runtimeException(RuntimeException e){
			return ResponseEntity.badRequest().body("Error " + e.getMessage());
	}
}
