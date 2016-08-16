package eu.arr.minipoco.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import eu.arr.minipoco.exception.ClientException;
import eu.arr.minipoco.response.ErrorResponse;

public class ExcptionController {

	@ExceptionHandler(ClientException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> ClientExceptionHandler(HttpServletRequest req, Exception e){

        ErrorResponse error = new ErrorResponse();

	    error.setErrorCode(HttpStatus.BAD_REQUEST.value());
	    error.setMessage(e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
