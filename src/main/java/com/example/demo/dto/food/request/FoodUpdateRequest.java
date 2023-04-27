package com.example.demo.dto.food.request;

import lombok.Getter;

@Getter
public class FoodUpdateRequest {

    private String foodName;
    private String foodPrice;
    private String foodDescription;
    private String foodCalorie;
    private String foodIngredient;
    private String foodCategory;
    private String foodImageUrl;

}
