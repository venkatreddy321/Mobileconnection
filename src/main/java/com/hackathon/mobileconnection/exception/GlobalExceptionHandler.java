package com.hackathon.mobileconnection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hackathon.mobileconnection.util.MobileConstants;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(MobileConstants.INTERNAL_SERVER_ERROR,
				HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}

	@ExceptionHandler(CustomerRequestNotFoundException.class)
	public ResponseEntity<ErrorResponse> customerExceptionHandler(CustomerRequestNotFoundException exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value()
				);
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);

	}
}