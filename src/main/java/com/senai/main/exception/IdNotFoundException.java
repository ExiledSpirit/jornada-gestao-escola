package com.senai.main.exception;

/**
 * Exception disparada sempre que um ID enviado na
 * request não existe
 */
public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String message) {
        super(message);
    }
}
