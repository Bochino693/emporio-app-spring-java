package com.sunatomsystems.ajatto.resources.exceptions;

import java.time.Instant;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sunatomsystems.ajatto.services.exceptions.ExceptionResponse;
import com.sunatomsystems.ajatto.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
				
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);			
		
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request ){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);		
	}
	
//	@ExceptionHandler(InvalidJwtAuthenticationException.class)
//	public final ResponseEntity<ExceptionResponse> handleInvalidJwtAuthenticationException(Exception ex,
//			WebRequest request ){
//		
//		ExceptionResponse exceptionResponse = new ExceptionResponse(
//				new Date(),
//				ex.getMessage(),
//				request.getDescription(false));		
//		
//		return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);		
//	}
//	
		

}
