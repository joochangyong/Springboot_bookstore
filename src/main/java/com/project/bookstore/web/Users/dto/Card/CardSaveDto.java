package com.project.bookstore.web.Users.dto.Card;

import java.sql.Date;

import com.project.bookstore.domain.Cards.Cards;
import com.project.bookstore.domain.Users.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CardSaveDto {
    private String cardNum;
    private String cardPeriod;
    private Long cardCVC;
    private String cardVal;
    private Users users;

    public Cards toEntity() {
        return Cards.builder()
                .cardNum(cardNum)
                .cardPeriod(cardPeriod)
                .cardCVC(cardCVC)
                .cardVal(cardVal)
                .users(users)
                .build();
    }
}