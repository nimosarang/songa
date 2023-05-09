package com.example.demo.controller.order;

import com.example.demo.dto.order.request.CreateOrderItemRequest;
import com.example.demo.dto.order.request.OrderRequest.CreateOrderRequest;
import com.example.demo.dto.order.response.OrderResponse;
import com.example.demo.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        OrderResponse orderResponse = orderService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long orderId) {
        OrderResponse orderResponse = orderService.getOrder(orderId);
        return ResponseEntity.ok(orderResponse);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResponse> updateOrder(
        @PathVariable Long orderId,
        @RequestBody CreateOrderRequest request) {
        OrderResponse orderResponse = orderService.updateOrder(orderId, request);
        return ResponseEntity.ok(orderResponse);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping("/{orderId}/orderItems")
//    public ResponseEntity<OrderResponse> addOrderItem(
//        @PathVariable Long orderId,
//        @RequestBody CreateOrderItemRequest request) {
//        OrderResponse orderResponse = orderService.addOrderItem(orderId, request);
//        return ResponseEntity.ok(orderResponse);
//    }
//
//    @DeleteMapping("/{orderId}/orderItems/{orderItemId}")
//    public ResponseEntity<Void> removeOrderItem(
//        @PathVariable Long orderId,
//        @PathVariable Long orderItemId) {
//        orderService.removeOrderItem(orderId, orderItemId);
//        return ResponseEntity.noContent().build();

}


