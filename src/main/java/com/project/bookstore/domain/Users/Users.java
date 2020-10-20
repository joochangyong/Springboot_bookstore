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
    private String pw;
    private String name;
    private String sex;
    private int num;
    private String mail;
    private String nic_name;

    @Builder
    public Users(String id, String pw, String name, String sex, int num, String mail, String nic_name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.mail = mail;
        this.nic_name = nic_name;
    }

    public void update(String pw, int num, String mail, String nic_name) {
        this.pw = pw;
        this.num = num;
        this.mail = mail;
        this.nic_name = nic_name;
    }
}
