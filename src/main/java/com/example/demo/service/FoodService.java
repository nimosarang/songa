package com.example.demo.service;

import com.example.demo.domain.food.Food;
import com.example.demo.dto.food.request.FoodCreateRequest;
import com.example.demo.dto.food.response.FoodResponse;
import com.example.demo.repository.FoodRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    //    public List<Food> getFoods() {
//        return foodRepository.findAll();
//    }
    public List<FoodResponse> getFoods() {
        return foodRepository.findAll().stream()
            .map(FoodResponse::new)
            .collect(Collectors.toList());
    }

    public void saveFood(FoodCreateRequest request) {
        foodRepository.save(new Food(request));
    }


}


