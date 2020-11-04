package com.project.bookstore.web.Books.dto;

import com.project.bookstore.domain.book.Books;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookSaveDto {
    private String ISBM;
    private String bookName;
    private String bookAut;
    private String bookTrans;
    private String bookHouse;
    private Date bookDate;
    private String bookCov;
    private int bookPri;
    private String bookGen;
    private String bookDet;

    @Builder
    public BookSaveDto(String ISBM, String bookName, String bookAut, String bookTrans, String bookHouse, Date bookDate, String bookCov, int bookPri, String bookGen, String bookDet) {
        this.ISBM = ISBM;
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

    public Books toEntity() {
        return Books.builder()
                .ISBM(ISBM)
                .bookName(bookName)
                .bookAut(bookAut)
                .bookTrans(bookTrans)
                .bookHouse(bookHouse)
                .bookDate(bookDate)
                .bookCov(bookCov)
                .bookPri(bookPri)
                .bookGen(bookGen)
                .bookDet(bookDet)
                .build();
    }
}
