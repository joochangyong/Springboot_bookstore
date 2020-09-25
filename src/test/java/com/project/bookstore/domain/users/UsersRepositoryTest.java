package com.project.bookstore.domain.users;

import com.project.bookstore.domain.book.Users;
import com.project.bookstore.domain.book.UsersRepository;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    @After
    public void cleanup() {
        usersRepository.deleteAll();
    }

    @Test
    public void 회원정보_불러오기() {
        //given
        String password = "qwer1234";
        String userName = "주창용";
        String sex = "남";
        String birthday = "960525";
        String phoneNumber = "01031033706";
        String email = "qq@qq";
        String address = "부산광역시 사상구 주례동";
        String nickName = "창용";

        //테이블 users에 insert/update 쿼리를 실행
        usersRepository.save(Users.builder()
                .password(password)
                .userName(userName)
                .sex(sex)
                .birthday(birthday)
                .phoneNumber(phoneNumber)
                .email(email)
                .address(address)
                .nickName(nickName)
                .build());

        //when. 테이블 users에 있는 모든 데이터를 조회해오는 메소드.
        List<Users> usersList = usersRepository.findAll();

        //then
        Users users = usersList.get(0);
        assertThat(users.getPassword()).isEqualTo(password);
        assertThat(users.getUserName()).isEqualTo(userName);
        assertThat(users.getSex()).isEqualTo(sex);
        assertThat(users.getBirthday()).isEqualTo(birthday);
        assertThat(users.getPhoneNumber()).isEqualTo(phoneNumber);
        assertThat(users.getEmail()).isEqualTo(email);
        assertThat(users.getAddress()).isEqualTo(address);
        assertThat(users.getNickName()).isEqualTo(nickName);
    }

}
