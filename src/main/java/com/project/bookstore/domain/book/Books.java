package com.project.bookstore.domain.book;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Books {

    @Id
    private String isbn;

    @Column(length = 500, nullable = false)
    private String bookName; //도서명
    private String bookAut; //저자
    private String bookTrans; //옮긴이
    private String bookHouse; //출판사
    private Date bookDate; //출간일
    private String bookCov; //표지
    private int bookPri; //가격
    private String bookGen; //장르
    private String bookDet; //상세정보

    @Builder
    public Books(String isbn, String bookName, String bookAut, String bookTrans, String bookHouse, Date bookDate, String bookCov, int bookPri, String bookGen, String bookDet) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookAut = bookAut;
        this.bookTrans = bookTrans;
        this.bookHouse = bookHouse;
        this.bookDate = bookDate;
        this.bookCov = bookCov;
        this.bookPri = bookPri;
        this.bookGen = bookGen;
        this.bookDet = bookDet;
    }

    public void bookUpdate(String bookTrans, String bookCov, int bookPri, String bookDet) {
        this.bookTrans = bookTrans;
        this.bookCov = bookCov;
        this.bookPri = bookPri;
        this.bookDet = bookDet;
    }
}
