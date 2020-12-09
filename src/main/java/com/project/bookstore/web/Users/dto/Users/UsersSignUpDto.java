package com.project.bookstore.web.Users.dto.Users;

import com.project.bookstore.domain.Users.Users;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UsersSignUpDto {
    private String id;
    private String pw;
    private String name;
    private String sex;
    private int num;
    private String mail;

    @Builder
    public UsersSignUpDto(String id, String pw, String name, String sex, int num, String mail) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.mail = mail;
    }

    public Users toEntity() {
        return Users.builder()
                .id(id)
                .pw(pw)
                .name(name)
                .sex(sex)
                .num(num)
                .mail(mail)
                .build();
    }
}
