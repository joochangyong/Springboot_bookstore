package com.project.bookstore.domain.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, String> {
//    Optional<Books> findById(String isbn);
    @Query("SELECT b FROM Books b ORDER BY b.isbn")
    List<Books> findAllBooks();

    //검색
    // Like문 정리 || Like "A" || Contaning "%A%" || StartingWith "A%" || EndingWith "%A"
    List<Books> findByBookNameContaining(String bookName);

    @Query("SELECT b FROM Books b WHERE b.isbn = ?1")
    List<Books> findBybookInfo(String isbn);
}
