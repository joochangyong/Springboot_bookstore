package com.project.bookstore.web.Users.dto.Basket;

import com.project.bookstore.domain.Basket.Basket;
import com.project.bookstore.domain.BasketInfo.BasketInfo;
import com.project.bookstore.domain.BasketInfo.BasketMultiId;
import com.project.bookstore.domain.Books.Books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketInfoDto{
    private BasketMultiId basketMultiId;
    private Long basAmount;
    private Basket basket;
    private Books books;
    
    public BasketInfoDto(BasketInfo entity) {
        this.basketMultiId = entity.getBasketMultiId();
        this.basAmount = entity.getBasAmount();
        this.basket = entity.getBasket();
        this.books = entity.getBooks();
    }
}
