package com.project.bookstore.web.Orders.dto;

import com.project.bookstore.domain.Books.Books;
import com.project.bookstore.domain.Orders.Orders;
import com.project.bookstore.domain.OrdersInfo.OrdersInfo;
import com.project.bookstore.domain.OrdersInfo.OrdersMultiId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrdersInsertDto {
    private OrdersMultiId ordersMultiId;
    private Long orderAmount;
    private Orders orders;
    private Books books;

    public OrdersInfo toEntity() {
        return OrdersInfo.builder()
        .ordersMultiId(ordersMultiId)
        .orderAmount(orderAmount)
        .orders(orders)
        .books(books)
        .build();
    }
}
