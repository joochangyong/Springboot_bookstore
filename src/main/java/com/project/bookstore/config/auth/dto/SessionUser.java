package com.project.bookstore.config.auth.dto;

import com.project.bookstore.domain.Users.Users;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String id;
    private String pw;


    public SessionUser(Users users) {
        this.id = users.getId();
        this.pw = users.getPw();
    }

}
