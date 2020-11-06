package com.project.bookstore.web.Books.dto;

import com.project.bookstore.domain.Books.Books;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookUpdateDto {
    private Long bookPri; //가격
    private String bookDet; //상세정보

    @Builder
    public BookUpdateDto(Books entity) {
        this.bookPri = entity.getBookPri();
        this.bookDet = entity.getBookDet();
    }
}
