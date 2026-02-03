package com.leonardoboff.RealShopMongo.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError err = new StandartError(System.currentTimeMillis(), status.value(), "Não Encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
