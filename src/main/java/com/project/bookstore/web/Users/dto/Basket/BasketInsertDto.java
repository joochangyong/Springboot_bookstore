package com.project.bookstore.web.Users.dto.Basket;

import com.project.bookstore.domain.Basket.Basket;
import com.project.bookstore.domain.BasketInfo.BasketInfo;
import com.project.bookstore.domain.BasketInfo.BasketMultiId;
import com.project.bookstore.domain.Books.Books;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasketInsertDto {
    private BasketMultiId basketMultiId;
    private Long basAmount;
    private Basket basket;
    private Books books;

    public BasketInfo toEntity() {
        return BasketInfo.builder()
        .basketMultiId(basketMultiId)
        .basAmount(basAmount)
        .basket(basket)
        .books(books)
        .build();
    }    
}
