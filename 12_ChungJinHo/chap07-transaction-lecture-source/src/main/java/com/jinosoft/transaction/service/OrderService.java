package com.jinosoft.transaction.service;

import com.jinosoft.transaction.domain.Order;
import com.jinosoft.transaction.domain.OrderMenu;
import com.jinosoft.transaction.dto.OrderDTO;
import com.jinosoft.transaction.dto.OrderMenuDTO;
import com.jinosoft.transaction.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service // Bean 등록
@AllArgsConstructor
public class OrderService {
  private final OrderMapper orderMapper;

  @Transactional(
          isolation = Isolation.DEFAULT,  // 하나의 트랜잭션으로 처리
          propagation = Propagation.REQUIRED, // 트랜잭션이 있으면 참여, 없으면 새엇ㅇ
          rollbackFor = Exception.class // 발생한 예외 종류 관계 없이 모두 롤백
      ) // 선언적 트랜잭션 처리 어노테이션
  public void registerOrder(OrderDTO orderDTO, List<OrderMenuDTO> orderMenuDTOs){
    Order order = new Order();
    order.setOrderDate(orderDTO.getOrderDate());
    order.setOrderTime(orderDTO.getOrderTime());
    order.setTotalOrderPrice(orderDTO.getTotalOrderPrice());

    orderMapper.insertOrder(order);

    int orderCode = order.getOrderCode();

    // DTO -> Domain 변환
    List<OrderMenu> orderMenus = orderMenuDTOs.stream().map(dto -> {
      OrderMenu om = new OrderMenu();
      om.setMenuCode(dto.getMenuCode());
      om.setOrderAmount(dto.getOrderAmount());
      // 주문 등록 후 auto generated 된 orderCode를 각 주문 메뉴에 설정
      om.setOrderCode(orderCode);
      return om;
    }).collect(Collectors.toList());

    orderMenus.forEach(orderMenu -> orderMapper.insertOrderMenu(orderMenu));

    // 강제 예외 발생 -> @Transactional 어노테이션이 작성된 서비스 메서드에서
    // 예외가 발생할 경우 rollback이 되는지 확인
    // if(1 == 1) throw new RuntimeException();
  }



}
