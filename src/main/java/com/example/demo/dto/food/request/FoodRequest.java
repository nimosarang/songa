package com.example.demo.dto.food.request;

import lombok.Getter;

@Getter
public class FoodRequest {

    private String foodName;
    private int foodPrice;
    private String foodDescription;
    private String foodCalorie;
    private String foodIngredient;
    private String foodCategory;
    private String foodImageUrl;
    private Long foodId;
    public Long getFoodId() {
        return foodId;
    }

    public static class CreateFoodRequest extends FoodRequest {

    }

    public static class UpdateFoodRequest extends FoodRequest {

    }

}



