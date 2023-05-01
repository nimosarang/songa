package com.example.demo.dto.order.request;

import lombok.Getter;

@Getter
public class CreateOrderItemRequest {
    private Long foodId;
    private int quantity;

    public CreateOrderItemRequest(Long foodId, int quantity) {
        this.foodId = foodId;
        this.quantity = quantity;
    }
}
