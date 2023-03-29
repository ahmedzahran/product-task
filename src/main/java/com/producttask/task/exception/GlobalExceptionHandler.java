package com.producttask.task.exception;

import dto.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BusinessExceptions.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GeneralResponse onBusinessException(BusinessExceptions businessExceptions){
        return new GeneralResponse(HttpStatus.BAD_REQUEST.value(),businessExceptions.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    GeneralResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        HashMap<String,String> responseMAp = new HashMap<>();

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            responseMAp.put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        return new GeneralResponse(HttpStatus.FORBIDDEN.value(),"validation errors",responseMAp);
    }
}
