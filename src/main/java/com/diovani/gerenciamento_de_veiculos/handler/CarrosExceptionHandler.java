package com.diovani.gerenciamento_de_veiculos.handler;

import com.diovani.gerenciamento_de_veiculos.exception.EntidadeNãoEncontradaException;
import com.diovani.gerenciamento_de_veiculos.exception.InternalServerErrorException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarrosExceptionHandler {

    @ExceptionHandler(EntidadeNãoEncontradaException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundError(Exception e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse errorResponse = new ErrorResponse(status.value(), e.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler({
            InternalServerErrorException.class
    })
    public ResponseEntity<ErrorResponse> handleInternalServerError(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse = new ErrorResponse(status.value(), e.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }

    @Getter
    private static class ErrorResponse {
        private int statusCode;
        private String message;

        public ErrorResponse(int statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }
    }
}
