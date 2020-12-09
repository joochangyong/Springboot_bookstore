package com.project.bookstore.web.Users.dto.Basket;

import com.project.bookstore.domain.Basket.Basket;
import com.project.bookstore.domain.Users.Users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasketCreateDto {
    private Users users;
    private String basCre;
    private Long basSum;

    public Basket toEntity() {
        return Basket.builder()
            .users(users)
            .basCre(basCre)
            .basSum(basSum)
            .build();
    }
}
