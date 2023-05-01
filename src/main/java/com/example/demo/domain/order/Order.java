package com.example.demo.domain.order;

import com.example.demo.domain.food.Food;
import com.example.demo.dto.order.request.OrderRequest;
import com.example.demo.dto.order.request.OrderRequest.CreateOrderRequest;
import com.example.demo.exception.order.OrderValidationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId; // 주문 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food; // 주문한 음식

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>(); // 주문한 음식 목록

    @Column(nullable = false)
    private int quantity; // 주문 수량

    private LocalDateTime orderedAt; // 주문 시각

    public Order(CreateOrderRequest request, Food food) {
        validateOrderRequest(request);
        this.food = food;
        this.quantity = request.getQuantity();
        this.orderedAt = LocalDateTime.now();
    }

    public void updateOrder(CreateOrderRequest request) {
        validateOrderRequest(request);
        this.quantity = request.getQuantity();
    }
    public void validateOrderRequest(OrderRequest request) {
        if (request.getFood() == null) {
            throw new OrderValidationException("음식은 필수! 입니다.");
        }

        if (request.getQuantity() <= 0) {
            throw new OrderValidationException("주문 수량은 0보다 커야 합니다.");
        }
    }

}
