package com.example.demo.service.order;

import com.example.demo.domain.food.Food;
import com.example.demo.domain.order.Order;
import com.example.demo.dto.order.request.CreateOrderItemRequest;
import com.example.demo.dto.order.request.OrderRequest;
import com.example.demo.dto.order.request.OrderRequest.CreateOrderRequest;
import com.example.demo.dto.order.response.OrderResponse;
import com.example.demo.exception.food.FoodNotFoundException;
import com.example.demo.exception.order.OrderNotFoundException;
import com.example.demo.repository.food.FoodRepository;
import com.example.demo.repository.order.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;

    public OrderService(OrderRepository orderRepository, FoodRepository foodRepository) {
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
    }

    public OrderResponse createOrder(CreateOrderRequest request) {
        Food food = foodRepository.findById(request.getFood().getFoodId())
            .orElseThrow(FoodNotFoundException::new);

        Order order = new Order(request, food);

        Order savedOrder = orderRepository.save(order);
        return new OrderResponse(savedOrder);
    }

    public OrderResponse getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(OrderNotFoundException::new);
        return new OrderResponse(order);
    }

    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(OrderNotFoundException::new);
        orderRepository.delete(order);
    }

    public OrderResponse updateOrder(Long orderId, CreateOrderRequest request) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(OrderNotFoundException::new);
        order.updateOrder(request);
        Order savedOrder = orderRepository.save(order);
        return new OrderResponse(savedOrder);
    }
}


