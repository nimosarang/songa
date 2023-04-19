package com.example.demo.controller;

import com.example.demo.service.FoodService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
}
