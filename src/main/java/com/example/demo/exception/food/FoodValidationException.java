package com.example.demo.exception.food;
public class FoodValidationException extends RuntimeException {
    public FoodValidationException(String message) {
        super(message);
    }
}
