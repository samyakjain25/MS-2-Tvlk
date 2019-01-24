package com.traveloka.ecommerce.controller;

import com.sun.xml.internal.ws.api.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(value = ProductNotfoundException.class)
    public ResponseEntity<Object> exception(ProductNotfoundException exception) {
        return new ResponseEntity<>("Oops!!\nProduct not found with id = " + exception.getMessage() + "\nTry again", HttpStatus.NOT_FOUND);
    }
}