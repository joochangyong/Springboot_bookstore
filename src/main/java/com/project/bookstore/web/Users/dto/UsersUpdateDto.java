package com.project.bookstore.web.Users.dto;

import com.project.bookstore.domain.Users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersUpdateDto {
    private String pw;
    private int num;
    private String mail;
    private String nic_name;

    @Builder
    public UsersUpdateDto(Users entity) {
        this.pw = entity.getPw();
        this.num = entity.getNum();
        this.mail = entity.getMail();
        this.nic_name = entity.getName();
    }
}
