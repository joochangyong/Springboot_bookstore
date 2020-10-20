package com.project.bookstore.domain.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, String> {
//    Optional<Users> findById(String id);
    @Query("SELECT u FROM Users u WHERE u.id = ?1")
    List<Users> findAllUsers(String id);
}