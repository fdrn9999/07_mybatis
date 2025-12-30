package com.jinosoft.dto;

import lombok.*;

/**
 * DTO showing Menu with its Category.
 * 메뉴 정보와 해당 카테고리 정보를 함께 담는 DTO 클래스입니다. (1:1 관계)
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MenuAndCategoryDTO {
    private int menuCode; // 메뉴 코드
    private String menuName; // 메뉴 이름
    private int menuPrice; // 메뉴 가격
    private CategoryDTO category; // 카테고리 정보 (Association)
    private String orderableStatus; // 주문 가능 여부
}
