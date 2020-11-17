package com.project.bookstore.service.users;

import com.project.bookstore.domain.Users.Users;
import com.project.bookstore.domain.Users.UsersMapperRepository;
import com.project.bookstore.domain.Users.UsersRepository;
import com.project.bookstore.web.Users.dto.Users.UsersInfoDto;
import com.project.bookstore.web.Users.dto.Users.UsersSignInDto;
import com.project.bookstore.web.Users.dto.Users.UsersSignUpDto;
import com.project.bookstore.web.Users.dto.Users.UsersUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final UsersMapperRepository usersMapperRepository;

    //회원가입
    @Transactional
    public String save(UsersSignUpDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getId();
    }

    //로그인
    public UsersInfoDto usersSign(UsersSignInDto signInDto) {
        return usersMapperRepository.usersSign(signInDto);
    }

    //회원가입시 중복확인 findById
    @Transactional
    public Users findById(String id) {
        Users entity = usersRepository.findById(id).orElseGet(Users::new);
        return entity;
    }

    //정보불러오기
    @Transactional
    public List<UsersInfoDto> findAllUsers(String id) {
        return usersRepository.findAllUsers(id).stream()
                .map(UsersInfoDto::new)
                .collect(Collectors.toList());
    }

    //회원정보수정
    @Transactional
    public Object Update(String id, UsersUpdateDto usersUpdateDto) {
        Users users = usersRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 아이디가 없습니다. id = " + id));
        users.update(usersUpdateDto.getPw(), usersUpdateDto.getNum(), usersUpdateDto.getMail());
        return id;
    }
}
