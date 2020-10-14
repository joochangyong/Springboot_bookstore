package com.project.bookstore.web.dto.Users;

import com.project.bookstore.domain.Users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersInfoDto {
    private String id;
    private String pw;
    private String name;
    private String sex;
    private int num;
    private String mail;
    private String nic_name;
    private int total_sum;

    public UsersInfoDto(Users entity) {
        this.id = entity.getId();
        this.pw = entity.getPw();
        this.name = entity.getName();
        this.sex = entity.getSex();
        this.num = entity.getNum();
        this.mail = entity.getMail();
        this.nic_name = entity.getName();
    }
}
