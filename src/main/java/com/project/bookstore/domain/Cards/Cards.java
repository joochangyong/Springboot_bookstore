package com.project.bookstore.domain.Cards;

import com.project.bookstore.domain.Users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Cards {

    @Id
    private String cardNum; //카드번호

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    private String cardPeriod; //유효기간
    private Long cardCVC; //CVC번호
    private String cardVal; //카드종류

    @Builder
    private Cards (Users users, String cardNum, String cardPeriod, Long cardCVC, String cardVal) {
        this.users = users;
        this.cardNum = cardNum;
        this.cardPeriod =cardPeriod;
        this.cardCVC = cardCVC;
        this.cardVal = cardVal;
    }
}
