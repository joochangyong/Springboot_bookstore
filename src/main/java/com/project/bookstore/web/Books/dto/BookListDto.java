package com.project.bookstore.web.Books.dto;

import com.project.bookstore.domain.book.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookListDto {
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

    public BookListDto(Books entity) {
        this.ISBM = entity.getISBM();
        this.book_Name = entity.getBook_Name();
        this.book_Aut = entity.getBook_Aut();
        this.book_House = entity.getBook_House();
        this.book_Date = entity.getBook_Date();
        this.book_Cov = entity.getBook_Cov();
        this.book_Pri = entity.getBook_Pri();
        this.book_Gen = entity.getBook_Gen();
        this.book_Det = entity.getBook_Det();
    }
}
