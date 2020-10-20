package com.project.bookstore.service.users;

import com.project.bookstore.domain.book.Books;
import com.project.bookstore.domain.book.BooksRepository;
import com.project.bookstore.web.Books.dto.BookListDto;
import com.project.bookstore.web.Books.dto.BooksSaveDto;
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
    public String booksave(BooksSaveDto booksSaveDto) {
        return booksRepository.save(booksSaveDto.toEntity()).getISBM();
    }
    
    //ISBM중복확인
    @Transactional
    public Books findById(String ISBM) {
        Books entity = booksRepository.findById(ISBM).orElseGet(Books::new);
        return entity;
    }
    //도서리스트
    @Transactional
    public List<BookListDto> findAllBooks() {
        return booksRepository.findAllBooks().stream()
                .map(BookListDto::new)
                .collect(Collectors.toList());
    }

    
}
