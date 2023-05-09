package com.example.demo.service.food;

import com.example.demo.domain.food.Food;
import com.example.demo.dto.food.request.FoodRequest.CreateFoodRequest;
import com.example.demo.dto.food.request.FoodRequest.UpdateFoodRequest;
import com.example.demo.dto.food.response.FoodResponse;
import com.example.demo.exception.food.FoodNotFoundException;
import com.example.demo.repository.food.FoodRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<FoodResponse> getFoods() {
        return foodRepository.findAll().stream()
            .map(FoodResponse::new)
            .collect(Collectors.toList());
    }

    public FoodResponse saveFood(CreateFoodRequest request) {
        Food saveFood = foodRepository.save(new Food(request));
        return new FoodResponse(saveFood);
    }

    public FoodResponse getFood(Long foodId) {
        Food food = foodRepository.findById(foodId)
            .orElseThrow(FoodNotFoundException::new);
        return new FoodResponse(food);
    }

    public void updateFood(Long foodId, UpdateFoodRequest request) {
        Food food = foodRepository.findById(foodId)
            .orElseThrow(FoodNotFoundException::new);
        food.updateFood(request);
        foodRepository.save(food);
    }

    public void deleteFood(Long foodId) {
        Food food = foodRepository.findById(foodId)
            .orElseThrow(FoodNotFoundException::new);
        foodRepository.delete(food);
    }

    public Food getFoodById(Long foodId) {
        return foodRepository.findById(foodId)
            .orElseThrow(FoodNotFoundException::new);
    }
}


