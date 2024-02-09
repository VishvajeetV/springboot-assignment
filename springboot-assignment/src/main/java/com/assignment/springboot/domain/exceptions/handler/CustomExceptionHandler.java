package com.assignment.springboot.domain.exceptions.handler;


import com.assignment.springboot.domain.api.resource.ResponseDTO;
import com.assignment.springboot.domain.exceptions.BusinessException;
import com.assignment.springboot.domain.exceptions.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(
        CustomException ex, WebRequest request) {
        String msg  = ex.getErrCode();
        Map<String, Object> body = getErrorReponseBody(ex);
        if(ex instanceof BusinessException){
            return new ResponseEntity(new ResponseDTO(String.valueOf(ex.getStatus().value()), msg, false, body), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(new ResponseDTO(String.valueOf(ex.getStatus().value()), msg, false, body), HttpStatus.OK);
    }

    @Deprecated
    public ResponseEntity<Object> AttachmentNotFound(
        MethodArgumentNotValidException ex, HttpHeaders headers,
        HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status.value());

        List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(x -> x.getDefaultMessage())
            .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    private static Map<String, Object> getErrorReponseBody(CustomException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("errors", ex.getErrors());
        body.put("statusCode", ex.getStatus().value());
        return body;
    }
 }
