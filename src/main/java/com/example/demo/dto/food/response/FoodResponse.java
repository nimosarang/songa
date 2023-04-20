package com.example.demo.dto.food.response;

import com.example.demo.domain.food.Food;
import java.util.Date;

public class FoodResponse {

    private long foodId;
    private String foodName;
    private String foodPrice;
    private String foodDescription;
    private String foodCalorie;
    private String foodIngredient;
    private String foodCategory;
    private String foodImageUrl;
    private Date foodCreatedAt;

    public FoodResponse(long foodId, String foodName, String foodPrice, String foodDescription,
        String foodCalorie, String foodIngredient, String foodCategory, String foodImageUrl,
        Date foodCreatedAt) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodDescription = foodDescription;
        this.foodCalorie = foodCalorie;
        this.foodIngredient = foodIngredient;
        this.foodCategory = foodCategory;
        this.foodImageUrl = foodImageUrl;
        this.foodCreatedAt = foodCreatedAt;
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

    public long getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public String getFoodCalorie() {
        return foodCalorie;
    }

    public String getFoodIngredient() {
        return foodIngredient;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public String getFoodImageUrl() {
        return foodImageUrl;
    }

    public Date getFoodCreatedAt() {
        return foodCreatedAt;
    }






}
