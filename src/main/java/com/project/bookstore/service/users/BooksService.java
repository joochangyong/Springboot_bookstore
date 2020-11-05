package com.project.bookstore.service.users;

import com.project.bookstore.domain.Books.Books;
import com.project.bookstore.domain.Books.BooksRepository;
import com.project.bookstore.web.Books.dto.BookListDto;
import com.project.bookstore.web.Books.dto.BookSaveDto;
import com.project.bookstore.web.Books.dto.BookUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BooksService {
    private final BooksRepository booksRepository;
    
    //도서등록
    @Transactional
    public String booksave(BookSaveDto booksSaveDto) {
        return booksRepository.save(booksSaveDto.toEntity()).getIsbn();
    }
    
    //isbn중복확인
    @Transactional
    public Books findById(String isbn) {
        Books entity = booksRepository.findById(isbn).orElseGet(Books::new);
        return entity;
    }
    //도서리스트
    @Transactional
    public List<BookListDto> findAllBooks() {
        return booksRepository.findAllBooks().stream()
                .map(BookListDto::new)
                .collect(Collectors.toList());
    }

    //도서 상세정보
    @Transactional
    public List<BookListDto> findBybookInfo(String isbn) {
        return booksRepository.findBybookInfo(isbn).stream()
                .map(BookListDto::new)
                .collect(Collectors.toList());
    }

    //도서 수정
    @Transactional
    public Books bookUpdate(String isbn, BookUpdateDto bookUpdateDto) {
        Books books = booksRepository.findById(isbn).orElseThrow(() -> new IllegalArgumentException("수정안됨"));
        books.bookUpdate(bookUpdateDto.getBookTrans(), bookUpdateDto.getBookCov(), bookUpdateDto.getBookPri(), bookUpdateDto.getBookDet());
        return books;
    }

    //도서 검색
    @Transactional
    public List<BookListDto> bookName(String bookName, BookListDto bookListDto) {
        return booksRepository.findByBookNameContaining(bookName).stream()
                .map(BookListDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (String isbn) {
        Books books = booksRepository.findById(isbn).orElseThrow(() -> new IllegalArgumentException("삭제안됨"));
        booksRepository.delete(books);
    }
}
