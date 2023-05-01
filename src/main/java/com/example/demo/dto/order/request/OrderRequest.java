package com.example.demo.dto.order.request;

import com.example.demo.dto.food.request.FoodRequest;
import lombok.Getter;

@Getter
public class OrderRequest {

    private FoodRequest food;
    private int quantity;

    public Long getFoodId() {
        return food.getFoodId();
    }

    public static class CreateOrderRequest extends OrderRequest {

    }
}
