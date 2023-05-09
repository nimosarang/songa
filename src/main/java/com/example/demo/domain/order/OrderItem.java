package com.example.demo.domain.order;

import com.example.demo.domain.food.Food;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order; // 주문

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food; // 주문한 음식

    protected OrderItem(Order order, Food food) {
        this.order = order;
        this.food = food;
    }

    public static OrderItem createOrderItem(Order order, Food food) {
        return new OrderItem(order, food);
    }

}
