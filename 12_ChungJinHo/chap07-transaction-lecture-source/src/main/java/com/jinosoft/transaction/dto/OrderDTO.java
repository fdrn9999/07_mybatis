package com.jinosoft.transaction.dto;

import lombok.*;

@Getter
@Setter
@ToString
public class OrderDTO {
  private String orderDate;
  private String orderTime;
  private int totalOrderPrice;
}