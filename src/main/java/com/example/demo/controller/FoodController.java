package com.example.demo.controller;

import com.example.demo.dto.food.request.FoodCreateRequest;
import com.example.demo.dto.food.response.FoodResponse;
import com.example.demo.service.FoodService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

//    @GetMapping("/foods")
//    public List<Food> getFoods() {return foodService.getFoods();}

    @GetMapping("/foods")
    public List<FoodResponse> getFoods() {
        return foodService.getFoods();
    }

    @PostMapping("/foods")
    public void saveFood(@RequestBody FoodCreateRequest request) {
        foodService.saveFood(request);
    }


}
