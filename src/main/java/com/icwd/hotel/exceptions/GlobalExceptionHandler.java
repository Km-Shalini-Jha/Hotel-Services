package com.icwd.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.icwd.hotel.payload.ApiResponseClass;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseClass> resourceNotFoundExcepHandler(ResourceNotFoundException ex){		
		return new ResponseEntity<>(new ApiResponseClass("false",String.valueOf(HttpStatus.NOT_FOUND),ex.getMessage()),HttpStatus.OK);	
	}

}



