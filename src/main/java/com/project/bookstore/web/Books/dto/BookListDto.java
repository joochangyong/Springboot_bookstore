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
    private String bookName;
    private String bookAut;
    private String bookTrans;
    private String bookHouse;
    private Date bookDate;
    private String bookCov;
    private int bookPri;
    private String bookGen;
    private String bookDet;

    public BookListDto(Books entity) {
        this.ISBM = entity.getISBM();
        this.bookName = entity.getBookName();
        this.bookAut = entity.getBookAut();
        this.bookTrans = entity.getBookTrans();
        this.bookHouse = entity.getBookHouse();
        this.bookDate = entity.getBookDate();
        this.bookCov = entity.getBookCov();
        this.bookPri = entity.getBookPri();
        this.bookGen = entity.getBookGen();
        this.bookDet = entity.getBookDet();
    }
}
