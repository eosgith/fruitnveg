/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.contollers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author eithn
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler 
  extends ResponseEntityExceptionHandler {
 
//    @ExceptionHandler(value 
//      = { Exception.class, DataIntegrityViolationException.class})
//    protected ResponseEntity<Object> handleConflict(
//       RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = "DataIntegrityViolationExeption " ;
//        System.out.println("test");
//        return handleExceptionInternal(ex, bodyOfResponse, 
//          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
//    }
}
