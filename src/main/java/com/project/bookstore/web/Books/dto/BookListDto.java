package com.project.bookstore.web.Books.dto;

import com.project.bookstore.domain.Books.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookListDto {
    private String isbn;
    private String bookName;
    private String bookAut;
    private String bookHouse;
    private Date bookDate;
    private Long bookPri;
    private String bookGen;
    private String bookDet;
    private int bookSto;

    public BookListDto(Books entity) {
        this.isbn = entity.getIsbn();
        this.bookName = entity.getBookName();
        this.bookAut = entity.getBookAut();
        this.bookHouse = entity.getBookHouse();
        this.bookDate = entity.getBookDate();
        this.bookPri = entity.getBookPri();
        this.bookGen = entity.getBookGen();
        this.bookDet = entity.getBookDet();
        this.bookSto = entity.getBookSto();
    }
}
