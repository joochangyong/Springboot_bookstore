package com.project.bookstore.web.Users.dto.Users;

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

    @Builder
    public UsersUpdateDto(Users entity) {
        this.pw = entity.getPw();
        this.num = entity.getNum();
        this.mail = entity.getMail();
    }
}
