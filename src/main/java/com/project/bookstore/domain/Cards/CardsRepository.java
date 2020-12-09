package com.project.bookstore.domain.Cards;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CardsRepository extends JpaRepository<Cards, String> {
    List<Cards> findByUsers_Id(String id);
}