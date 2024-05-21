package com.ideyalabs.demoproject.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String s) {
        super(s);
    }
}
