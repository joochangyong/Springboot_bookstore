package com.project.bookstore.domain.Posts;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entity클래스, PK타입> 기본적인 CRUD메소드가 자동 생성.
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
