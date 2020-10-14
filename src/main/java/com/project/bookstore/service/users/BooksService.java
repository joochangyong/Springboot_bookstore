package com.project.bookstore.service.users;

import com.project.bookstore.domain.book.BooksRepository;
import com.project.bookstore.web.dto.Books.BooksSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Transactional
    public String booksave(BooksSaveDto booksSaveDto) {
        return booksRepository.save(booksSaveDto.toEntity()).getISBM();
    }
}
