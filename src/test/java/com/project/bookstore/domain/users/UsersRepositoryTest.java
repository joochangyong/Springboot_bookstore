//package com.project.bookstore.domain.users;
//
//import com.project.bookstore.domain.Users.Users;
//import com.project.bookstore.domain.Users.UsersRepository;
//import org.junit.After;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UsersRepositoryTest {
//
//    @Autowired
//    UsersRepository usersRepository;
//
//    @After
//    public void cleanup() {
//        usersRepository.deleteAll();
//    }
//
//    @Test
//    public void 회원정보_불러오기() {
//        //given
//        String pw = "qwer1234";
//        String name = "주창용";
//        String sex = "남";
//        String num = "01031033706";
//        String mail = "qq@qq";
//        String nic_Name = "창용";
//
//        //테이블 users에 insert/update 쿼리를 실행
//        usersRepository.save(Users.builder()
//                .pw(pw)
//                .name(name)
//                .sex(sex)
//                .num(num)
//                .mail(mail)
//                .nic_Name(nic_Name)
//                .build());
//
//        //when. 테이블 users에 있는 모든 데이터를 조회해오는 메소드.
//        List<Users> usersList = usersRepository.findAll();
//
//        //then
//        Users users = usersList.get(0);
//        assertThat(users.getPw()).isEqualTo(pw);
//        assertThat(users.getName()).isEqualTo(name);
//        assertThat(users.getSex()).isEqualTo(sex);
//        assertThat(users.getNum()).isEqualTo(num);
//        assertThat(users.getMail()).isEqualTo(mail);
//        assertThat(users.getNic_name()).isEqualTo(nic_Name);
//    }
//
//}
