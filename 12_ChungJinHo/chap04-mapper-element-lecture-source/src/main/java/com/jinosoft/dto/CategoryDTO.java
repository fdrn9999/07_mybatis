package com.jinosoft.dto;

import lombok.*;

/**
 * Category Data Transfer Object.
 * 카테고리 정보를 담는 DTO 클래스입니다.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CategoryDTO {
    private int categoryCode; // 카테고리 코드
    private String categoryName; // 카테고리 이름
    private Integer refCategoryCode; // 상위 카테고리 코드
}