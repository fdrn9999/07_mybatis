package com.jinosoft.transaction.mapper;


import com.jinosoft.transaction.domain.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
  void insertOrder(Order order);

  void insertOrderMenu(OrderMenu orderMenu);


}
