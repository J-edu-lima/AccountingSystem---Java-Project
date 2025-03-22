package com.j_edulima.accouting.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler extends DefaultResponseErrorHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ResponseError> notFound(ObjectNotFoundException e, HttpServletRequest request) {
		String erro = "OBJETO NÃO ENCONTRADO";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ResponseError responseError = new ResponseError(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(responseError);
	}

	@ExceptionHandler(DataErrorException.class)
	public ResponseEntity<ResponseError> data(DataErrorException e, HttpServletRequest request) {
		String erro = "DADOS INCORRETOS";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ResponseError responseError = new ResponseError(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(responseError);
	}

	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<ResponseError> password(InvalidEmailException e, HttpServletRequest request) {
		String erro = "EMAIL INVÁLIDO";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ResponseError responseError = new ResponseError(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(responseError);
	}

	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ResponseError> password(InvalidPasswordException e, HttpServletRequest request) {
		String erro = "SENHA INVÁLIDA";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ResponseError responseError = new ResponseError(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(responseError);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseError> httpRequest(HttpMessageNotReadableException e, HttpServletRequest request) {
		String erro = "VALOR INSERIDO INVÁLIDO";
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
		ResponseError responseError = new ResponseError(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(responseError);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ResponseError> argumentTypeMismatch(MethodArgumentTypeMismatchException e,
			HttpServletRequest request) {
		String erro = "VALOR INSERIDO INVÁLIDO";
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
		ResponseError responseError = new ResponseError(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(responseError);
	}
}