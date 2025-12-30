package com.jinosoft.mapper;

import com.jinosoft.dto.CategoryAndMenuDTO;
import com.jinosoft.dto.MenuAndCategoryDTO;
import com.jinosoft.dto.MenuDTO;

import java.util.List;

/**
 * Mapper Interface for testing MyBatis ResultMaps.
 * MyBatis의 Mapper XML 파일과 매핑되는 인터페이스입니다.
 */
public interface ElementTestMapper {

  /**
   * 기본 ResultMap 테스트용 메소드
   * 
   * @return 전체 메뉴 목록 리스트
   */
  List<MenuDTO> selectResultMapTest();

  /**
   * Association (1:1 관계) 매핑 테스트용 메소드
   * Menu와 Category를 조인하여 조회합니다.
   * 
   * @return 메뉴와 카테고리 정보가 포함된 리스트
   */
  List<MenuAndCategoryDTO> selectResultMapAssociationTest();

  /**
   * Collection (1:N 관계) 매핑 테스트용 메소드
   * Category와 해당 카테고리에 속한 Menu 목록을 조회합니다.
   * 
   * @return 카테고리와 메뉴 목록 정보가 포함된 리스트
   */
  List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}