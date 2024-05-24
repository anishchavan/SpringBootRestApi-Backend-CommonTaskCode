package edu.cjc.springbootrestapicrudapp.app.exception;




import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<APIError> productNotFoundExceptionHandler(ProductNotFoundException e, HttpServletRequest request){
		APIError error = new APIError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpMessage(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<APIError>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> ArithmeticExceptionHandler(ArithmeticException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomerListIsEmptyException.class)
	public ResponseEntity<String> CustomerListIsEmptyExceptionHandler(CustomerListIsEmptyException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
