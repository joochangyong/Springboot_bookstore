package com.project.bookstore.domain.Addr;

import com.project.bookstore.domain.Books.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddrRepository extends JpaRepository<Addr, Long> {
    List<Addr> findByUsers_Id(String id);

    List<Books> findByaddrCode(Long addrCode);
}
