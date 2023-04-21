package com.example.demo.domain.food;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId = null; // 음식 id

    @Column(nullable = false, length = 20)
    private String foodName; // 음식 이름

    private String foodPrice; // 음식 가격

    private String foodDescription; // 음식 설명
    private String foodCalorie; // 칼로리
    private String foodIngredient;  // 재료

    private String foodCategory;  // 카테고리

    private String foodImageUrl;  // 이미지 url

    private Date foodCreatedAt;  // 생성일

    public Food(String foodName) {
        if (foodName == null || foodName.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 foodName(%s)이 들어왔습니다", foodName));
        }
        this.foodName = foodName;
    }

    public Long getFoodId() {
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
