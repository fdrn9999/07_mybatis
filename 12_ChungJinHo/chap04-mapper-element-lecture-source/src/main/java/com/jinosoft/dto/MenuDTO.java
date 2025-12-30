package com.jinosoft.dto;

import lombok.*;

/**
 * Menu Data Transfer Object.
 * 메뉴 정보를 담는 DTO 클래스입니다.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MenuDTO {

    private int menuCode; // 메뉴 코드 (식별자)
    private String menuName; // 메뉴 이름
    private int menuPrice; // 메뉴 가격
    private int categoryCode; // 카테고리 코드 (FK)
    private String orderableStatus; // 주문 가능 여부 (Y/N)
}