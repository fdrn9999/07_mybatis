package com.jinosoft.service;

import com.jinosoft.dto.CategoryAndMenuDTO;
import com.jinosoft.dto.MenuAndCategoryDTO;
import com.jinosoft.dto.MenuDTO;
import com.jinosoft.mapper.ElementTestMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.jinosoft.common.Template.getSqlSession;

/**
 * Service class that handles business logic and interacts with the Mapper.
 * 비즈니스 로직을 처리하고 Mapper와 상호작용하는 서비스 클래스입니다.
 */
public class ElementTestService {

    /**
     * 기본 ResultMap 기능을 테스트하는 메소드입니다.
     * SqlSession을 생성하고 Mapper를 통해 쿼리를 실행한 후 결과를 출력합니다.
     */
    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapTest();

        if (menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("조회 결과 없음");
        }

        sqlSession.close();
    }

    /**
     * Association (1:1 관계) 매핑을 테스트하는 메소드입니다.
     * 메뉴와 해당 메뉴의 카테고리 정보를 함께 조회하여 출력합니다.
     */
    public void selectResultMapAssociationTest() {
        SqlSession sqlSession = getSqlSession();
        ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuAndCategoryDTO> menuList = mapper.selectResultMapAssociationTest();

        if (menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("조회 결과 없음");
        }

        sqlSession.close();
    }

    /**
     * Collection (1:N 관계) 매핑을 테스트하는 메소드입니다.
     * 카테고리와 해당 카테고리에 속한 메뉴 목록을 함께 조회하여 출력합니다.
     */
    public void selectResultMapCollectionTest() {
        SqlSession sqlSession = getSqlSession();
        ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<CategoryAndMenuDTO> categoryList = mapper.selectResultMapCollectionTest();

        if (categoryList != null && !categoryList.isEmpty()) {
            categoryList.forEach(System.out::println);
        } else {
            System.out.println("조회 결과 없음");
        }

        sqlSession.close();
    }
}