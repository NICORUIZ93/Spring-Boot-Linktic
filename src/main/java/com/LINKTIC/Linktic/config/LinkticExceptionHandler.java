package com.LINKTIC.Linktic.config;

import com.LINKTIC.Linktic.config.ex.Linktic;
import com.LINKTIC.Linktic.models.DTO.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkticExceptionHandler {
    @ExceptionHandler(Linktic.class)
    public ResponseEntity<ErrorDto> handleGenericException(Linktic ex) {
        ErrorDto errorDto = ErrorDto.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
        return new ResponseEntity<>("Ocurrió un error inesperado." + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
