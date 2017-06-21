package com.cooksys.friendlr.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cooksys.friendlr.exception.PersonNotFoundException;
import com.cooksys.friendlr.exception.PetNotFoundException;

@ControllerAdvice
public class FriendlrExceptionHandler extends ResponseEntityExceptionHandler {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler
	public ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException ex, WebRequest request) {
		
		log.warn(ex.getMessage());
		
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handlePetNotFoundException(PetNotFoundException ex, WebRequest request) {
		log.warn(ex.getMessage());
		
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

}
