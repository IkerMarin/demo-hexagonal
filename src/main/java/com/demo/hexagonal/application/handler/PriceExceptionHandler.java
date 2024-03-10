package com.demo.hexagonal.application.handler;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.demo.hexagonal.application.utils.GeneralUtils;
import com.demo.hexagonal.domain.exception.PriceNotFoundException;

@ControllerAdvice
public class PriceExceptionHandler {
	
    @ResponseBody
    @ExceptionHandler(value = {PriceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(PriceNotFoundException priceNotFoundException) {
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message("No se han encontrado registros para los datos introducidos")
                .build();
    }
    
    @ResponseBody
    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleIllegalArgumentException(IllegalArgumentException exception) {
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message("Todos los parámetros son obligatorios")
                .build();
    }
    
    @ResponseBody
    @ExceptionHandler(value = {DateTimeParseException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleDateTimeParseException(DateTimeParseException exception) {
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message("Formato de fecha erróneo: El formato ha de ser: "+GeneralUtils.YYYY_MM_DD_HH_MM_SS_PATTERN)
                .build();
    }
    

}
