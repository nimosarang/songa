package com.example.demo.dto.order.response;

import com.example.demo.domain.order.Order;
import com.example.demo.dto.food.response.FoodResponse;
import lombok.Getter;

@Getter
public class OrderResponse {

    private Long orderId;
    private FoodResponse food;
    private int quantity;
    private String orderedAt;

    public OrderResponse(Order order) {
        this.food = new FoodResponse(order.getFood());
        this.orderId = order.getOrderId();
        this.quantity = order.getQuantity();
        this.orderedAt = order.getOrderedAt().toString();
    }
}
