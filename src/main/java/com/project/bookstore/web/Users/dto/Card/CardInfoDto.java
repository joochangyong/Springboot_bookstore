package com.project.bookstore.web.Users.dto.Card;

import com.project.bookstore.domain.Cards.Cards;
import com.project.bookstore.domain.Users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardInfoDto {
    private String cardNum;
    private String cardPeriod;
    private Long cardCVC;
    private String cardVal;
    private Users users;

    public CardInfoDto(Cards entity) {
        this.cardNum = entity.getCardNum();
        this.cardPeriod = entity.getCardPeriod();
        this.cardCVC = entity.getCardCVC();
        this.cardVal = entity.getCardVal();
        this.users = entity.getUsers();
    }
}
