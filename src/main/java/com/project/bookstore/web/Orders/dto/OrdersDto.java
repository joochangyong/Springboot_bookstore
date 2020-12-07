package com.project.bookstore.web.Orders.dto;

import java.util.Date;

import com.project.bookstore.domain.Orders.Orders;
import com.project.bookstore.domain.Users.Users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrdersDto {
    private Users users;
    private Long addrCode;
    private Date orderDate;
    private Long orderSum;
    private Long orderZip;
    private String orderBas;
    private String orderDet;
    private String cardNum;
    private String cardPeriod;
    private String carVal;

    public Orders toEntity() {
        return Orders.builder()
        .users(users)
        .orderDate(orderDate)
        .orderSum(orderSum)
        .orderZip(orderZip)
        .orderBas(orderBas)
        .orderDet(orderDet)
        .cardNum(cardNum)
        .cardPeriod(cardPeriod)
        .carVal(carVal)
        .build();
    }
}
