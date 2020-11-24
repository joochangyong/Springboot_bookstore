package com.project.bookstore.domain.Books;

import com.project.bookstore.domain.BasketInfo.BasketInfo;
import com.project.bookstore.domain.OrdersInfo.OrdersInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Books {

    @Id
    private String isbn;

    private String bookName; //도서명
    private String bookAut; //저자
    private String bookHouse; //출판사
    private Date bookDate; //출간일
    private Long bookPri; //가격
    private String bookGen; //장르
    private String bookDet; //상세정보
    private int bookSto;

    @OneToMany(mappedBy = "books")
    private List<BasketInfo> basketInfo;

    @OneToMany(mappedBy = "books")
    private List<OrdersInfo> ordersInfo;

    @Builder
    public Books(String isbn, String bookName, String bookAut, String bookHouse, Date bookDate, Long bookPri, String bookGen, String bookDet, int bookSto,
                 List<BasketInfo> basketInfo, List<OrdersInfo> ordersInfo) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookAut = bookAut;
        this.bookHouse = bookHouse;
        this.bookDate = bookDate;
        this.bookPri = bookPri;
        this.bookGen = bookGen;
        this.bookDet = bookDet;
        this.bookSto = bookSto;
        this.basketInfo = basketInfo;
        this.ordersInfo = ordersInfo;
    }

    public void bookUpdate(Long bookPri, String bookDet) {
        this.bookPri = bookPri;
        this.bookDet = bookDet;
    }
}
