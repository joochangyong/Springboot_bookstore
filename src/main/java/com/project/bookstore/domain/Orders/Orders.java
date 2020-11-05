package com.project.bookstore.domain.Orders;

import com.project.bookstore.domain.OrdersInfo.OrdersInfo;
import com.project.bookstore.domain.Users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCode; //주문코드

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    private Date orderDate; //주문일자
    private Long orderSum; //주문총액
    private Long orderZip; //주문우편번호
    private String orderBas; //주문기본주소
    private String orderDet; //주문상세주소

    @OneToMany(mappedBy = "orders")
    private List<OrdersInfo> ordersInfo;


    @Builder
    private Orders (Users users, Date orderDate, Long orderSum, Long orderZip, String orderBas, String orderDet, List<OrdersInfo> ordersInfo) {
        this.users = users;
        this.orderDate = orderDate;
        this.orderSum = orderSum;
        this.orderZip = orderZip;
        this.orderBas = orderBas;
        this.orderDet = orderDet;
        this.ordersInfo = ordersInfo;
    }
}
