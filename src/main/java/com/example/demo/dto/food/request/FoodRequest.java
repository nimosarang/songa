package com.example.demo.dto.food.request;

import lombok.Getter;

@Getter
public class FoodRequest {

    private String foodName;
    private String foodPrice;
    private String foodDescription;
    private String foodCalorie;
    private String foodIngredient;
    private String foodCategory;
    private String foodImageUrl;

    public static class CreateFoodRequest extends FoodRequest {

    }

    public static class UpdateFoodRequest extends FoodRequest {

    }

}



