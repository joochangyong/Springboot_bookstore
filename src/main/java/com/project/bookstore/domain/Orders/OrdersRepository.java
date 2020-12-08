package com.project.bookstore.domain.Orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByUsers_Id(String userid);
}
