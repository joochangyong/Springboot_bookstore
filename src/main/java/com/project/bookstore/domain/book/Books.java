package com.project.bookstore.domain.book;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Books {

    @Id
    private String ISBM;

    @Column(length = 500, nullable = false)
    private String book_Name; //도서명
    private String book_Aut; //저자
    private String book_Trans; //옮긴이
    private String book_House; //출판사
    private Date book_Date; //출간일
    private String book_Cov; //표지
    private int book_Pri; //가격
    private String book_Gen; //장르
    private String book_Det; //상세정보

    @Builder
    public Books(String ISBM, String book_Name, String book_Aut, String book_Trans, String book_House, Date book_Date, String book_Cov, int book_Pri, String book_Gen, String book_Det) {
        this.ISBM = ISBM;
        this.book_Name = book_Name;
        this.book_Aut = book_Aut;
        this.book_Trans = book_Trans;
        this.book_House = book_House;
        this.book_Date = book_Date;
        this.book_Cov = book_Cov;
        this.book_Pri = book_Pri;
        this.book_Gen = book_Gen;
        this.book_Det = book_Det;
    }
}
