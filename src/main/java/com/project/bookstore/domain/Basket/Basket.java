package com.project.bookstore.domain.Basket;

import com.project.bookstore.domain.BasketInfo.BasketInfo;
import com.project.bookstore.domain.Users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basNum; //장바구니 번호

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    private String basCre; //장바구니 생성일자
    private Long basSum; //물건총가격

    @OneToMany(mappedBy = "basket") //mappdeBy : 관계의 주인을 정의.
    private List<BasketInfo> basketInfo;

    @Builder
    private Basket (Users users, String basCre, Long basSum, List<BasketInfo> basketInfo) {
        this.users = users;
        this.basCre = basCre;
        this.basSum = basSum;
        this.basketInfo = basketInfo;
    }

}
