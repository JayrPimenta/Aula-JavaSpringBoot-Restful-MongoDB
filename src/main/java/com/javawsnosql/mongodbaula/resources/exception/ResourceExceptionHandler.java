package com.javawsnosql.mongodbaula.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.javawsnosql.mongodbaula.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ModeloPadraoParaErro> objectNotFound(ObjectNotFoundException e, HttpServletRequest request ) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		ModeloPadraoParaErro erroModelo = new ModeloPadraoParaErro(System.currentTimeMillis(), 
				status.value(), 
				"Recurso não encontrado", 
				e.getMessage(), 
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(erroModelo);
		
	}
}
