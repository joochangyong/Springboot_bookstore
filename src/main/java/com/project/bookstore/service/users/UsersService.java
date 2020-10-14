package com.project.bookstore.service.users;

import com.project.bookstore.domain.Users.UsersMapperRepository;
import com.project.bookstore.domain.Users.UsersRepository;
import com.project.bookstore.web.dto.Users.UsersInfoDto;
import com.project.bookstore.web.dto.Users.UsersSignInDto;
import com.project.bookstore.web.dto.Users.UsersSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final UsersMapperRepository usersMapperRepository;

    @Transactional
    public String save(UsersSignUpDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getId();
    }

    public UsersInfoDto usersSign(UsersSignInDto signInDto) {
        return usersMapperRepository.usersSign(signInDto);
    }
}
