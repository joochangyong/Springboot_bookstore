package com.project.bookstore.domain.OrdersInfo;

import com.project.bookstore.domain.Books.Books;
import com.project.bookstore.domain.Orders.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
public class OrdersInfo implements Serializable {
    @EmbeddedId
    private OrdersMultiId ordersMultiId;

    private Long orderAmount; //주문 수량

    @MapsId("orderCode")
    @ManyToOne
    @JoinColumn(name = "order_code")
    private Orders orders;

    @MapsId("isbn")
    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Books books;

    @Builder
    private OrdersInfo (OrdersMultiId ordersMultiId, Long orderAmount, Orders orders, Books books) {
        this.ordersMultiId = ordersMultiId;
        this.orderAmount = orderAmount;
        this.orders = orders;
        this.books = books;
    }

}
