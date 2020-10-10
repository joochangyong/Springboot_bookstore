package com.project.bookstore.web.dto;

import com.project.bookstore.domain.Users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersSignUpDto {
    private String id;
    private String pw;
    private String name;
    private String sex;
    private int num;
    private String mail;
    private String nic_name;

    @Builder
    public UsersSignUpDto(String id, String pw, String name, String sex, int num, String mail, String nic_name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.mail = mail;
        this.nic_name = nic_name;
    }

    public Users toEntity() {
        return Users.builder()
                .id(id)
                .pw(pw)
                .name(name)
                .sex(sex)
                .num(num)
                .mail(mail)
                .nic_name(nic_name)
                .build();
    }
}
