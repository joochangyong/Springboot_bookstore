package com.project.bookstore.domain.Orders;

import com.project.bookstore.domain.OrdersInfo.OrdersInfo;
import com.project.bookstore.domain.Users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private String orderDate; //주문일자
    private Long orderSum; //주문총액
    private Long orderZip; //주문우편번호
    private String orderBas; //주문기본주소
    private String orderDet; //주문상세주소

    private String cardNum; //카드번호
    private String cardPeriod; //유효기간
    private String carVal; //카드종류

    @OneToMany(mappedBy = "orders")
    private List<OrdersInfo> ordersInfo;

    @Builder
    private Orders (Users users, String orderDate, Long orderSum, Long orderZip, String orderBas, String orderDet, String cardNum, String cardPeriod, String carVal, List<OrdersInfo> ordersInfo) {
        this.users = users;
        this.orderDate = orderDate;
        this.orderSum = orderSum;
        this.orderZip = orderZip;
        this.orderBas = orderBas;
        this.orderDet = orderDet;
        this.cardNum = cardNum;
        this.cardPeriod = cardPeriod;
        this.carVal = carVal;
        this.ordersInfo = ordersInfo;
    }
}
