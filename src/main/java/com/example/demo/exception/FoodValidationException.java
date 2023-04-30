package com.example.demo.exception;

import com.example.demo.dto.food.request.FoodRequest;

public class FoodValidationException extends RuntimeException {
    public FoodValidationException(String message) {
        super(message);
    }
}
