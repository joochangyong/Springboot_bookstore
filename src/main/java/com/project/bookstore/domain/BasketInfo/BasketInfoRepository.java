package com.project.bookstore.domain.BasketInfo;

import java.util.List;

import com.project.bookstore.domain.Basket.Basket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketInfoRepository extends JpaRepository<BasketInfo, Long> {
    
    List<BasketInfo> findByBasket(Basket basket);

    BasketInfo findByBasketMultiId(BasketMultiId basketMultiId);
}
