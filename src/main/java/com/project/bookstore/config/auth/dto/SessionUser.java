package com.project.bookstore.config.auth.dto;

import com.project.bookstore.domain.Users.Users;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String id;
    private String pw;
//    private String name;
//    private String sex;
//    private int num;
//    private String mail;
//    private String nic_name;

    public SessionUser(Users users) {
        this.id = users.getId();
        this.pw = users.getPw();
//        this.name = users.getName();
//        this.sex = users.getSex();
//        this.num = users.getNum();
//        this.mail = users.getMail();
//        this.nic_name = users.getName();
    }

}
