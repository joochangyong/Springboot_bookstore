package com.project.bookstore.domain.posts;

import com.project.bookstore.domain.Posts.Posts;
import com.project.bookstore.domain.Posts.PostsRepository;
import org.junit.After;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //postsRepository.save. 테이블 posts에 insert/update 쿼리를 실행합니다. 있으면 update, 없으면 insert
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("wnckddyd0525@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); //postsRepository.findAll. posts테이블의 모든 데이터를 조회.

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
