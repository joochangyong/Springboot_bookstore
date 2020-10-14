package com.project.bookstore.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, String> {
//    Optional<Books> findById(String ISBM);
}
