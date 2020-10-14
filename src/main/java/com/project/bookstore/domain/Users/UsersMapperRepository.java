package com.project.bookstore.domain.Users;

import com.project.bookstore.web.dto.Users.UsersInfoDto;
import com.project.bookstore.web.dto.Users.UsersSignInDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapperRepository {
    public UsersInfoDto usersSign(UsersSignInDto usersSignInDto);
}

