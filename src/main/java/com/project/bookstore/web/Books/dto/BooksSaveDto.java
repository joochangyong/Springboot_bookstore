package com.project.bookstore.web.Books.dto;

import com.project.bookstore.domain.book.Books;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BooksSaveDto {
    private String ISBM;
    private String book_Name;
    private String book_Aut;
    private String book_Trans;
    private String book_House;
    private Date book_Date;
    private String book_Cov;
    private int book_Pri;
    private String book_Gen;
    private String book_Det;

    @Builder
    public BooksSaveDto(String ISBM, String book_Name, String book_Aut, String book_Trans, String book_House, Date book_Date, String book_Cov, int book_Pri, String book_Gen, String book_Det) {
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

    public Books toEntity() {
        return Books.builder()
                .ISBM(ISBM)
                .book_Name(book_Name)
                .book_Aut(book_Aut)
                .book_Trans(book_Trans)
                .book_House(book_House)
                .book_Date(book_Date)
                .book_Cov(book_Cov)
                .book_Pri(book_Pri)
                .book_Gen(book_Gen)
                .book_Det(book_Det)
                .build();
    }
}
