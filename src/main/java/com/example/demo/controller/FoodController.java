package com.example.demo.controller;

import com.example.demo.dto.food.request.FoodCreateRequest;
import com.example.demo.dto.food.request.FoodUpdateRequest;
import com.example.demo.dto.food.response.FoodResponse;
import com.example.demo.service.FoodService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foods")
    public List<FoodResponse> getFoods() {
        return foodService.getFoods();
    }

    @PostMapping("/foods")
    public void saveFood(@RequestBody FoodCreateRequest request) {
        foodService.saveFood(request);
    }

    @GetMapping("/foods/{id}")
    public FoodResponse getFoodById(@PathVariable long id) {
        return foodService.getFoodById(id);
    }

    @PutMapping("/foods/{id}")
    public void updateFoodById(@PathVariable long id, @RequestBody FoodUpdateRequest request) {
        foodService.updateFoodById(id, request);
    }

    @DeleteMapping("/foods/{id}")
    public void deleteFoodById(@PathVariable long id) {
        foodService.deleteFoodById(id);
    }


}
