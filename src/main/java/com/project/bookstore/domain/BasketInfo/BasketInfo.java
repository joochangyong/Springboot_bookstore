package com.project.bookstore.domain.BasketInfo;

import com.project.bookstore.domain.Basket.Basket;
import com.project.bookstore.domain.Books.Books;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
public class BasketInfo implements Serializable {
    @EmbeddedId
    private BasketMultiId basketMultiId; //복합키
    private Long basAmount; // 주문 수량

    @MapsId("basNum") // 포함 된 ID의 basNum 속성을 매핑합니다.
    @ManyToOne
    @JoinColumn(name = "bas_num")
    private Basket basket;

    @MapsId("isbn")
    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Books books;

    @Builder
    public BasketInfo(BasketMultiId basketMultiId, Long basAmount, Basket basket, Books books) {
        this.basketMultiId = basketMultiId;
        this.basAmount = basAmount;
        this.basket = basket;
        this.books = books;
    }
}