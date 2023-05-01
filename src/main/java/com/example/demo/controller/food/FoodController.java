package com.example.demo.controller.food;

import com.example.demo.dto.food.request.FoodRequest.CreateFoodRequest;
import com.example.demo.dto.food.request.FoodRequest.UpdateFoodRequest;
import com.example.demo.dto.food.response.FoodResponse;
import com.example.demo.service.food.FoodService;
import java.util.List;
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
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public ResponseEntity<List<FoodResponse>> getFoods() {
        List<FoodResponse> foodResponses = foodService.getFoods();
        return ResponseEntity.ok(foodResponses);
    }
    @GetMapping("/{foodId}")
    public ResponseEntity<FoodResponse> getFood(@PathVariable Long foodId) {
        FoodResponse foodResponse = foodService.getFood(foodId);
        return ResponseEntity.ok(foodResponse);
    }

    @PostMapping
    public ResponseEntity<FoodResponse> saveFood(@RequestBody CreateFoodRequest request) {
        FoodResponse savedFood = foodService.saveFood(request);
        return ResponseEntity.ok(savedFood);
    }

    //ResponseEntity.ok().build()는 상태 코드 200을 반환하고 별도의 본문 데이터를 가지지 않는 응답을 생성.

    @PutMapping("/{foodId}")
    public ResponseEntity<UpdateFoodRequest> updateFood(@PathVariable Long foodId, @RequestBody UpdateFoodRequest request) {
        foodService.updateFood(foodId, request);
        return ResponseEntity.ok(request);
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long foodId) {
        foodService.deleteFood(foodId);
        return ResponseEntity.noContent().build();
        //noContent()는 204 No Content 상태 코드를 포함하는 응답 객체를 생성하는 메서드.
    }
}
