package com.example.demo.domain.food;

import java.util.Date;

public class Food {

    private Long foodId; // 음식 id
    private String foodName; // 음식 이름
    private String foodPrice; // 음식 가격

    private String foodDescription; // 음식 설명
    private String foodCalorie; // 칼로리
    private String foodIngredient;  // 재료
//    private String foodAllergy; // 알러지

    private String foodCategory;  // 카테고리
//    private String foodStore;  // 매장
//    private String foodStoreLocation;  // 매장 위치

    private String foodImageUrl;  // 이미지 url

    private Date foodCreatedAt;  // 생성일
//    private Date foodUpdatedAt;  // 수정일

    public Food() {}


}
