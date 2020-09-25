package com.project.bookstore.domain.book;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(length = 500, nullable = false)
    private String password;
    private String userName;
    private String sex;
    private String birthday;
    private String phoneNumber;
    private String email;
    private String address;
    private String nickName;

    @Builder
    public Users(String password, String userName, String sex, String birthday, String phoneNumber, String email, String address, String nickName) {
        this.password = password;
        this.userName = userName;
        this.sex = sex;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.nickName = nickName;
    }
}
