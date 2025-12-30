package com.jinosoft.springmybatis.section01.factorybean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuDTO {
  private int menuCode;
  private String menuName;
  private int menuPrice;
  private int categoryCode;
  private String orderableStatus;
}
