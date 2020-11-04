package com.project.bookstore.web.Books.dto;

import com.project.bookstore.domain.book.Books;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookUpdateDto {
    private String bookTrans; //옮긴이
    private String bookCov; //표지
    private int bookPri; //가격
    private String bookDet; //상세정보

    @Builder
    public BookUpdateDto(Books entity) {
        this.bookTrans = entity.getBookTrans();
        this.bookCov = entity.getBookCov();
        this.bookPri = entity.getBookPri();
        this.bookDet = entity.getBookDet();
    }
}
