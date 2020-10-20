package com.project.bookstore.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, String> {
//    Optional<Books> findById(String ISBM);
    @Query("SELECT b FROM Books b ORDER BY b.ISBM DESC")
    List<Books> findAllBooks();
}
