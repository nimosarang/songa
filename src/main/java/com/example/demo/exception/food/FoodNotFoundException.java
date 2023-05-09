package com.example.demo.exception.food;

public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException(String message) {
        super(message);
    }

    public FoodNotFoundException() {
        super("해당 음식을 찾을 수 없습니다.");
    }

}
