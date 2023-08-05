package com.example.customer.exception;

public class CustomerNotFoundException extends RuntimeException {
    private String message;

    public CustomerNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
