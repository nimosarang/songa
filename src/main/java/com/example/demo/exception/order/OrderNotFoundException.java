package com.example.demo.exception.order;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException() {
        super("해당 주문을 찾을 수 없습니다.");
    }

}
