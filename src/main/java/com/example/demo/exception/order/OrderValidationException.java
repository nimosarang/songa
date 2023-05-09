package com.example.demo.exception.order;

public class OrderValidationException extends RuntimeException{
    public OrderValidationException(String message) {
        super(message);
    }

}
