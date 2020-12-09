package com.project.bookstore.domain.Basket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    Basket findByUsers_Id(String userid);
}
