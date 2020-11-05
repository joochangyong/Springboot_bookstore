package com.project.bookstore.domain.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    private String id;

    @Column(length = 500, nullable = false)
    private String pw; //비밀번호
    private String name; //이름
    private String sex; //성별
    private int num; //전화번호
    private String mail; //이메일
    private String nicName; //닉네임

    @Builder
    public Users(String id, String pw, String name, String sex, int num, String mail, String nicName) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.mail = mail;
        this.nicName = nicName;
    }

    public Users update(String pw, int num, String mail, String nicName) {
        this.pw = pw;
        this.num = num;
        this.mail = mail;
        this.nicName = nicName;
        return this;
    }
}
