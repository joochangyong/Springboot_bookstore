package com.project.bookstore.domain.OrdersInfo;

import java.util.List;

import com.project.bookstore.domain.Orders.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersInfoRepository extends JpaRepository<OrdersInfo, Long>{

    List<OrdersInfo> findTop1ByOrders(Orders orders);
}
