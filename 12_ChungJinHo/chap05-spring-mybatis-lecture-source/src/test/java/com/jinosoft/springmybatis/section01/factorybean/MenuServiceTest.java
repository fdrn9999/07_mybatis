package com.jinosoft.springmybatis.section01.factorybean;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MenuServiceTest {

  @Mock
  private SqlSessionTemplate sqlSessionTemplate;

  @Mock
  private MenuMapper menuMapper;

  @InjectMocks
  private MenuService menuService;

  @Test
  @DisplayName("주문 가능 상태인 메뉴 조회 테스트")
  void testFindAllMenuByOrderableStatus_shouldReturnMenusWithOrderableStatusY() {
    // Arrange
    String orderableStatus = "Y";
    MenuDTO menu1 = new MenuDTO(1, "Pizza", 1299, 1, "Y");
    MenuDTO menu2 = new MenuDTO(2, "Burger", 899, 1, "Y");

    when(sqlSessionTemplate.getMapper(MenuMapper.class)).thenReturn(menuMapper);
    when(menuMapper.findAllMenuByOrderableStatus(orderableStatus))
        .thenReturn(Arrays.asList(menu1, menu2));

    // Act
    List<MenuDTO> result = menuService.findAllMenuByOrderableStatus(orderableStatus);

    // Assert
    assertThat(result).hasSize(2);
    assertThat(result.get(0).getMenuName()).isEqualTo("Pizza(주문 가능)");
    assertThat(result.get(1).getMenuName()).isEqualTo("Burger(주문 가능)");

    verify(sqlSessionTemplate).getMapper(MenuMapper.class);
    verify(menuMapper).findAllMenuByOrderableStatus(orderableStatus);
  }

  @Test
  @DisplayName("주문 불가능 상태인 메뉴 조회 테스트")
  void testFindAllMenuByOrderableStatus_shouldReturnMenusWithOrderableStatusN() {
    // Arrange
    String orderableStatus = "N";
    MenuDTO menu1 = new MenuDTO(3, "Pasta", 1099, 2, "N");
    MenuDTO menu2 = new MenuDTO(4, "Salad", 749, 2, "N");

    when(sqlSessionTemplate.getMapper(MenuMapper.class)).thenReturn(menuMapper);
    when(menuMapper.findAllMenuByOrderableStatus(orderableStatus))
        .thenReturn(Arrays.asList(menu1, menu2));

    // Act
    List<MenuDTO> result = menuService.findAllMenuByOrderableStatus(orderableStatus);

    // Assert
    assertThat(result).hasSize(2);
    assertThat(result.get(0).getMenuName()).isEqualTo("Pasta(주문 불가능)");
    assertThat(result.get(1).getMenuName()).isEqualTo("Salad(주문 불가능)");

    verify(sqlSessionTemplate).getMapper(MenuMapper.class);
    verify(menuMapper).findAllMenuByOrderableStatus(orderableStatus);
  }

  @Test
  @DisplayName("결과가 없는 경우 빈 리스트 반환 테스트")
  void testFindAllMenuByOrderableStatus_shouldReturnEmptyListForNoResults() {
    // Arrange
    String orderableStatus = "Y";

    when(sqlSessionTemplate.getMapper(MenuMapper.class)).thenReturn(menuMapper);
    when(menuMapper.findAllMenuByOrderableStatus(orderableStatus))
        .thenReturn(Collections.emptyList());

    // Act
    List<MenuDTO> result = menuService.findAllMenuByOrderableStatus(orderableStatus);

    // Assert
    assertThat(result).isEmpty();

    verify(sqlSessionTemplate).getMapper(MenuMapper.class);
    verify(menuMapper).findAllMenuByOrderableStatus(orderableStatus);
  }
}