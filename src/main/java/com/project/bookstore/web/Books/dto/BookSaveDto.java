package com.project.bookstore.web.Books.dto;

import com.project.bookstore.domain.Books.Books;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookSaveDto {
    private String isbn;
    private String bookName;
    private String bookAut;
    private String bookHouse;
    private Date bookDate;
    private Long bookPri;
    private String bookGen;
    private String bookDet;
    private int bookSto;

    @Builder
    public BookSaveDto(String isbn, String bookName, String bookAut,  String bookHouse, Date bookDate, Long bookPri, String bookGen, String bookDet, int bookSto) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookAut = bookAut;
        this.bookHouse = bookHouse;
        this.bookDate = bookDate;
        this.bookPri = bookPri;
        this.bookGen = bookGen;
        this.bookDet = bookDet;
        this.bookSto = bookSto;
    }

    public Books toEntity() {
        return Books.builder()
                .isbn(isbn)
                .bookName(bookName)
                .bookAut(bookAut)
                .bookHouse(bookHouse)
                .bookDate(bookDate)
                .bookPri(bookPri)
                .bookGen(bookGen)
                .bookDet(bookDet)
                .bookSto(bookSto)
                .build();
    }
}
