package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

 class ExceptionController{
		@ExceptionHandler(value = IdNotFoundException.class)
		
		  public ResponseEntity<Object> exception(IdNotFoundException exception) {
	
		   return new ResponseEntity<>(" Id not Found", HttpStatus.NOT_FOUND);
	
		  }
		
		@ExceptionHandler(value = InvalidStoreIdException.class)
		
		  public ResponseEntity<Object> exception(InvalidStoreIdException exception) {
	
		   return new ResponseEntity<>(" Id not Found", HttpStatus.NOT_FOUND);
	
		  }
}
