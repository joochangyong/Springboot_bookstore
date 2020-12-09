package com.project.bookstore.domain.Users;

import com.project.bookstore.domain.Addr.Addr;
import com.project.bookstore.domain.Basket.Basket;
import com.project.bookstore.domain.Cards.Cards;
import com.project.bookstore.domain.Orders.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    private String id;

    @Column(length = 500, nullable = false)
    private String pw; //비밀번호
    private String name; //이름
    private String sex; //성별
    private int num; //전화번호
    private String mail; //이메일

    @OneToMany(mappedBy = "users")
    private List<Addr> addr;

    @OneToMany(mappedBy = "users")
    private List<Cards> cards;

    @OneToMany(mappedBy = "users")
    private List<Basket> basket;

    @OneToMany(mappedBy = "users")
    private List<Orders> orders;


    @Builder
    public Users(String id, String pw, String name, String sex, int num, String mail,
                 List<Addr> addr, List<Cards> cards, List<Basket> basket, List<Orders> orders) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.mail = mail;
        this.addr = addr;
        this.cards = cards;
        this.basket = basket;
        this.orders = orders;
    }

    public Users update(String pw, int num, String mail) {
        this.pw = pw;
        this.num = num;
        this.mail = mail;
        return this;
    }
}
