package com.example.demo.repository.food;

import com.example.demo.domain.food.Food;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findByFoodName(String foodName);
    Optional<Food> findById(Long foodId);

}
