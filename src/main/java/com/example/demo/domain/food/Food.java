package com.example.demo.domain.food;

import com.example.demo.domain.order.OrderItem;
import com.example.demo.dto.food.request.FoodRequest;
import com.example.demo.dto.food.request.FoodRequest.UpdateFoodRequest;
import com.example.demo.exception.food.FoodValidationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long foodId = null; // 음식 id

    @Column(nullable = false, length = 20)
    private String foodName; // 음식 이름

    @Column(nullable = false)
    private int foodPrice; // 음식 가격

    private String foodDescription; // 음식 설명
    private String foodCalorie; // 칼로리
    private String foodIngredient;  // 재료
    private String foodCategory;  // 카테고리
    private String foodImageUrl;  // 이미지 url

    private LocalDateTime foodCreatedAt;  // 생성일
    private LocalDateTime foodUpdatedAt;  // 수정일

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>(); // 주문한 항목들

    public Food(FoodRequest request) {
        validateFoodNameAndPrice(request);
        assignFood(request);
        addFoodCreatedAt();
    }

    public void updateFood(UpdateFoodRequest request) {
        validateFoodNameAndPrice(request);
        assignFood(request);
        addFoodUpdatedAt();
    }

    private void assignFood(FoodRequest request) {
        foodName = request.getFoodName();
        foodPrice = request.getFoodPrice();
        foodDescription = request.getFoodDescription();
        foodCalorie = request.getFoodCalorie();
        foodIngredient = request.getFoodIngredient();
        foodCategory = request.getFoodCategory();
        foodImageUrl = request.getFoodImageUrl();
    }

    private void addFoodCreatedAt() {
        foodCreatedAt = LocalDateTime.now();
    }

    private void addFoodUpdatedAt() {
        foodUpdatedAt = LocalDateTime.now();
    }

    public void validateFoodNameAndPrice(FoodRequest request) {
        if (request.getFoodName() == null || request.getFoodName().isBlank()) {
            throw new FoodValidationException("음식 이름은 필수! 입니다.");
        }

        if (request.getFoodPrice() == 0) {
            throw new FoodValidationException("음식 가격은 0보다 커야 합니다!");
        }
    }
}
