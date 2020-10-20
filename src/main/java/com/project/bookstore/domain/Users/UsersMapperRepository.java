package com.project.bookstore.domain.Users;

import com.project.bookstore.web.Users.dto.UsersInfoDto;
import com.project.bookstore.web.Users.dto.UsersSignInDto;
import com.project.bookstore.web.Users.dto.UsersSignUpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapperRepository {
    public UsersInfoDto usersSign(UsersSignInDto usersSignInDto);
    public UsersSignUpDto save(UsersSignUpDto usersSignUpDto);
}

