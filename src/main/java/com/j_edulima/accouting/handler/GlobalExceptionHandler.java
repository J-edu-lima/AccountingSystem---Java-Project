package com.j_edulima.accouting.handler;

import java.time.Instant;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
class GlobalExceptionHandler implements WebMvcConfigurer {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ResponseError> handleObjectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        String erro = "OBJETO NÃO ENCONTRADO";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ResponseError responseError = new ResponseError(
                Instant.now(),
                status.value(),
                erro,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(responseError);
    }

    @ExceptionHandler(DataErrorException.class)
    public ResponseEntity<ResponseError> handleDataError(DataErrorException e, HttpServletRequest request) {
        String erro = "DADOS INCORRETOS";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ResponseError responseError = new ResponseError(
                Instant.now(),
                status.value(),
                erro,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(responseError);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseError> handleHttpRequest(HttpMessageNotReadableException e, HttpServletRequest request) {
        String erro = "VALOR INSERIDO INVÁLIDO";
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        ResponseError responseError = new ResponseError(
                Instant.now(),
                status.value(),
                erro,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(responseError);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseError> handleArgumentTypeMismatch(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        String erro = "VALOR INSERIDO INVÁLIDO";
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        ResponseError responseError = new ResponseError(
                Instant.now(),
                status.value(),
                erro,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(responseError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Erro de integridade de dados: Usuário já está inserido no sistema");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointer(NullPointerException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Erro de busca de dados: nenhum usuário foi encontrado");
    }
}