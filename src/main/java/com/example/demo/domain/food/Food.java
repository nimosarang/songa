package com.example.demo.domain.food;

import com.example.demo.dto.food.request.FoodCreateRequest;
import com.example.demo.dto.food.request.FoodUpdateRequest;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId = null; // 음식 id

    @Column(nullable = false, length = 20)
    private String foodName; // 음식 이름

    @Column(nullable = false, length = 10)
    private String foodPrice; // 음식 가격

    private String foodDescription; // 음식 설명
    private String foodCalorie; // 칼로리
    private String foodIngredient;  // 재료
    private String foodCategory;  // 카테고리
    private String foodImageUrl;  // 이미지 url

    @Column(nullable = false)
    private LocalDateTime foodCreatedAt;  // 생성일

    @Column(nullable = true)
    private LocalDateTime foodUpdatedAt;  // 수정일

    public Food(FoodCreateRequest request) {

        if (request.getFoodName() == null || request.getFoodName().isBlank()) {
            throw new IllegalArgumentException("음식 이름은 필수! 입니다");
        }

        if (request.getFoodPrice() == null || request.getFoodPrice().isBlank()) {
            throw new IllegalArgumentException("음식 가격은 필수! 입니다");
        }

        this.foodName = request.getFoodName();
        this.foodPrice = request.getFoodPrice();
        this.foodDescription = request.getFoodDescription();
        this.foodCalorie = request.getFoodCalorie();
        this.foodIngredient = request.getFoodIngredient();
        this.foodCategory = request.getFoodCategory();
        this.foodImageUrl = request.getFoodImageUrl();
        this.foodCreatedAt = LocalDateTime.now();
    }


    public void updateFood(FoodUpdateRequest request) {

            if (request.getFoodName() == null || request.getFoodName().isBlank()) {
                throw new IllegalArgumentException("음식 이름은 필수! 입니다");
            }

            if (request.getFoodPrice() == null || request.getFoodPrice().isBlank()) {
                throw new IllegalArgumentException("음식 가격은 필수! 입니다");
            }

            this.foodName = request.getFoodName();
            this.foodPrice = request.getFoodPrice();
            this.foodDescription = request.getFoodDescription();
            this.foodCalorie = request.getFoodCalorie();
            this.foodIngredient = request.getFoodIngredient();
            this.foodCategory = request.getFoodCategory();
            this.foodImageUrl = request.getFoodImageUrl();
            this.foodUpdatedAt = LocalDateTime.now();
    }
}
