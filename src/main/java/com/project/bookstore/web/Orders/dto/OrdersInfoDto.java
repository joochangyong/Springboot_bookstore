package com.project.bookstore.web.Orders.dto;

import com.project.bookstore.domain.Books.Books;
import com.project.bookstore.domain.Orders.Orders;
import com.project.bookstore.domain.OrdersInfo.OrdersInfo;
import com.project.bookstore.domain.OrdersInfo.OrdersMultiId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersInfoDto {
    private OrdersMultiId ordersMultiId;
    private Long orderAmount;
    private Orders orders;
    private Books books;

    public OrdersInfoDto(OrdersInfo entity) {
        this.ordersMultiId = entity.getOrdersMultiId();
        this.orderAmount = entity.getOrderAmount();
        this.orders = entity.getOrders();
        this.books = entity.getBooks();
    }
    
}
