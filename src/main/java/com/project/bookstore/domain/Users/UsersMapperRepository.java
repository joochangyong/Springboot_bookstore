package com.project.bookstore.domain.Users;

import com.project.bookstore.web.dto.UsersSignInDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapperRepository {
    public UsersSignInDto usersSign(UsersSignInDto usersSignInDto);
}

