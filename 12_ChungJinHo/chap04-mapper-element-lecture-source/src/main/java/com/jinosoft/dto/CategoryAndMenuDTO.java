package com.jinosoft.dto;

import lombok.*;

import java.util.List;

/**
 * DTO showing Category with its list of Menus.
 * 카테고리 정보와 해당 카테고리에 속한 메뉴 목록을 함께 담는 DTO 클래스입니다. (1:N 관계)
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CategoryAndMenuDTO {
    private int categoryCode; // 카테고리 코드
    private String categoryName; // 카테고리 이름
    private Integer refCategoryCode; // 상위 카테고리 코드 (Nullable)
    private List<MenuDTO> menuList; // 해당 카테고리의 메뉴 목록 (Collection)
}