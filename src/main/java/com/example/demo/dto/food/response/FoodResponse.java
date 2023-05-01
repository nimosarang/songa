package com.example.demo.dto.food.response;

import com.example.demo.domain.food.Food;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class FoodResponse {

    private long foodId;
    private String foodName;
    private int foodPrice;
    private String foodDescription;
    private String foodCalorie;
    private String foodIngredient;
    private String foodCategory;
    private String foodImageUrl;
    private LocalDateTime foodCreatedAt;
    public FoodResponse() {
    }

    public FoodResponse(Food food){
        this.foodId = food.getFoodId();
        this.foodName = food.getFoodName();
        this.foodPrice = food.getFoodPrice();
        this.foodDescription = food.getFoodDescription();
        this.foodCalorie = food.getFoodCalorie();
        this.foodIngredient = food.getFoodIngredient();
        this.foodCategory = food.getFoodCategory();
        this.foodImageUrl = food.getFoodImageUrl();
        this.foodCreatedAt = food.getFoodCreatedAt();
    }

    public static class UpdateFoodResponse extends FoodResponse {

    }

}
