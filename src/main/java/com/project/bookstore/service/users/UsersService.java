package com.project.bookstore.service.users;

import com.project.bookstore.domain.Users.UsersRepository;
import com.project.bookstore.web.dto.UsersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service

public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional
    public String save(UsersDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getId();
    }
}
